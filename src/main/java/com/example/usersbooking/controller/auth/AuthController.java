package com.example.usersbooking.controller.auth;

import com.example.usersbooking.service.auth.IAuthService;
import com.example.usersbooking.utils.dto.AuthenticationRequest;
import com.example.usersbooking.utils.dto.AuthenticationResponse;
import com.example.usersbooking.utils.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService service;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        String jwt = service.login(request.getEmail(), request.getPassword());
        if(!jwt.isEmpty()){
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }
        else{
            throw new InvalidCredentialsException();
        }
    }
}
