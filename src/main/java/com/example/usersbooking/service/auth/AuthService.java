package com.example.usersbooking.service.auth;

import com.example.usersbooking.security.JWTGenerate;
import com.example.usersbooking.utils.dto.OperatorDto;
import com.example.usersbooking.model.Operator;
import com.example.usersbooking.repository.IAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthService implements  IAuthService {
    private static final String EMPTY_STRING="";

    @Autowired
    private JWTGenerate jwtGenerate;

    @Autowired
    IAuthRepository repository;

    @Override
    public Operator save(OperatorDto operator){
        return this.repository.save(new Operator(operator));
    }

    @Override
    public String login(String email, String password){
        Operator user = this.findByEmail(email);
        if(user !=null) {
            if (BCrypt.checkpw(password, user.getPasswordHash())) {
                return jwtGenerate.generateToken(user);
            }
        }
        return EMPTY_STRING;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User("Nelson","Vass123", new ArrayList<>());
    }

    public Operator findByEmail(String email) {
        if(!email.isEmpty()){
            Optional<Operator> operator = this.repository.findFirstByEmail(email);
            return operator.isPresent()? operator.get():null;
        }

        return null;
    }
}
