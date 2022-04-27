package com.example.usersbooking.service.auth;

import com.example.usersbooking.security.JWTGenerate;
import com.example.usersbooking.utils.dto.OperatorRequestDto;
import com.example.usersbooking.model.Operator;
import com.example.usersbooking.repository.IAuthRepository;
import com.example.usersbooking.utils.dto.OperatorResponseDto;
import com.example.usersbooking.utils.exceptions.InvalidParameterException;
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
    public OperatorResponseDto save(OperatorRequestDto operatorRequest) {
        Operator user = this.findByEmail(operatorRequest.getEmail());
        if (user == null) {
            Operator result = this.authRepository.save(new Operator(operatorRequest));
            return this.mapOperatorResponse(result);
        }
        else{
            throw new InvalidParameterException("Ya existe un usuario registrado con este email.");
        }
    }

    @Override
    public String login(String email, String password){
        Operator operator = this.findByEmail(email);
        if(operator != null) {
            if (operator.getCurrentToken() != null && !operator.getCurrentToken().isEmpty() && !operator.getCurrentToken().equals("")
                && (jwtGenerate.validateToken(operator.getCurrentToken(), operator))) {
                    return operator.getCurrentToken();
            }
            else if (BCrypt.checkpw(password, operator.getPasswordHash())) {
                //return jwtGenerate.generateToken(operator);
                OperatorRequestDto operatorRequest = new OperatorRequestDto();
                String generatedToken = jwtGenerate.generateToken(operator);
                operator.setCurrentToken(generatedToken);
                this.authRepository.save(operator);
                return generatedToken;
            }
        }
        return EMPTY_STRING;
    }

    public Operator findByEmail(String email) {
        if(!email.isEmpty()){
            Optional<Operator> operator = this.authRepository.findFirstByEmail(email);
            return operator.isPresent()? operator.get() : null;
        }
        return null;
    }

    @Override
    public OperatorResponseDto deleteById(String operatorId) {
        Optional<Operator> operator = this.authRepository.findById(operatorId);
        if(operator.isPresent()) {
            this.authRepository.deleteById(operatorId);
            return this.mapOperatorResponse(operator.get());
        }
        else{
            throw new InvalidParameterException("El identificador no existe.");
        }
    }

    private OperatorResponseDto mapOperatorResponse(Operator operator){
        OperatorResponseDto response = new OperatorResponseDto();
        response.setEmail(operator.getEmail());
        response.setName(operator.getName());
        response.setLastName(operator.getLastName());
        return response;
    }
}
