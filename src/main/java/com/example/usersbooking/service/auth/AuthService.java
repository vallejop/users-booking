package com.example.usersbooking.service.auth;

import com.example.usersbooking.security.JWTGenerate;
import com.example.usersbooking.utils.dto.OperatorDto;
import com.example.usersbooking.model.Operator;
import com.example.usersbooking.repository.IAuthRepository;
import com.example.usersbooking.utils.dto.OperatorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService implements  IAuthService {
    private static final String EMPTY_STRING="";

    @Autowired
    private JWTGenerate jwtGenerate;

    @Autowired
    IAuthRepository authRepository;

    @Override
    public OperatorResponseDto save(OperatorDto operator){
        Operator result = this.authRepository.save(new Operator(operator));
        OperatorResponseDto response = new OperatorResponseDto();
        response.setEmail(result.getEmail());
        response.setName(result.getName());
        response.setLastName(result.getLastName());
        return response;
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

    public Operator findByEmail(String email) {
        if(!email.isEmpty()){
            Optional<Operator> operator = this.authRepository.findFirstByEmail(email);
            return operator.isPresent()? operator.get():null;
        }

        return null;
    }
}
