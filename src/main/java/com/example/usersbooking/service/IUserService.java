package com.example.usersbooking.service;

import com.example.usersbooking.dto.UserDto;
import com.example.usersbooking.model.User;

public interface IUserService {
    Iterable<UserDto> getAll();
    UserDto getById(String id);
    UserDto updateSuscription(UserDto user,String id);
    UserDto create(UserDto userDto);
    User delete(UserDto userDto, String id);

}