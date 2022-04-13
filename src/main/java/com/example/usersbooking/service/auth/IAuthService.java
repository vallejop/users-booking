package com.example.usersbooking.service.auth;

import com.example.usersbooking.utils.dto.OperatorDto;
import com.example.usersbooking.model.Operator;

public interface IAuthService {
    Operator save(OperatorDto operator);
    String login(String email,String password);
    Operator findByEmail(String email);
}
