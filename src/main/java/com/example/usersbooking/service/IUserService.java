package com.example.usersbooking.service;

import com.example.usersbooking.dto.UserDto;

public interface IUserService {
    Iterable<UserDto> getAll();
    Boolean register(UserDto user);
    UserDto getById(String id);
    UserDto updateSuscription(UserDto user);
    Boolean delete(String id);
}