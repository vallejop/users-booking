package com.example.usersbooking.service.auth;

import com.example.usersbooking.utils.dto.OperatorDto;
import com.example.usersbooking.model.Operator;
import com.example.usersbooking.utils.dto.OperatorResponseDto;

public interface IAuthService {
    OperatorResponseDto save(OperatorDto operator);
    String login(String email, String password);
    Operator findByEmail(String email);
}
