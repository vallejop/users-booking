package com.example.usersbooking.service;

import com.example.usersbooking.dto.UserDto;

public interface IUserService {
    Iterable<UserDto> getAll();
    UserDto getById(String id);
    UserDto updateSuscription(UserDto user,String id);
}