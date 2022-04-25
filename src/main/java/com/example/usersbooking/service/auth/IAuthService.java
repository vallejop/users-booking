package com.example.usersbooking.service.auth;

import com.example.usersbooking.utils.dto.OperatorRequestDto;
import com.example.usersbooking.model.Operator;
import com.example.usersbooking.utils.dto.OperatorResponseDto;
import com.example.usersbooking.utils.errors.InvalidParameterErrorException;

import java.security.InvalidParameterException;

public interface IAuthService {
    OperatorResponseDto save(OperatorRequestDto operatorRequest);
    String login(String email, String password);
    Operator findByEmail(String email);
    OperatorResponseDto deleteById(String operatorId);
}
