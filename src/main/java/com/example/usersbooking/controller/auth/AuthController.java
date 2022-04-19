package com.example.usersbooking.controller.auth;

import com.example.usersbooking.model.Operator;
import com.example.usersbooking.service.auth.IAuthService;
import com.example.usersbooking.utils.dto.AuthenticationRequest;
import com.example.usersbooking.utils.dto.AuthenticationResponse;
import com.example.usersbooking.utils.dto.OperatorDto;
import com.example.usersbooking.utils.dto.OperatorResponseDto;
import com.example.usersbooking.utils.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        String jwt = authService.login(request.getEmail(), request.getPassword());
        if(!jwt.isEmpty()){
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }
        else{
            throw new InvalidCredentialsException();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<OperatorResponseDto> create(@Valid @RequestBody OperatorDto user){
        return new ResponseEntity<>(authService.save(user),HttpStatus.CREATED);
    }
}
