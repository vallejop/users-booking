package com.example.usersbooking.service.auth;

import com.example.usersbooking.utils.dto.OperatorRequestDto;
import com.example.usersbooking.model.Operator;
import com.example.usersbooking.utils.dto.OperatorResponseDto;

public interface IAuthService {
    OperatorResponseDto save(OperatorRequestDto operatorRequest);
    String login(String email, String password);
    Operator findByEmail(String email);
    OperatorResponseDto deleteById(String operatorId);
}
