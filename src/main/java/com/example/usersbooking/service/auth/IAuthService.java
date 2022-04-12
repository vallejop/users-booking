package com.example.usersbooking.service.auth;

import com.example.usersbooking.utils.dto.OperatorDto;
import com.example.usersbooking.model.Operator;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAuthService extends UserDetailsService {
    Operator save(OperatorDto operator);
    String login(String email,String password);
    Operator findByEmail(String email);
}
