package com.example.usersbooking.controller;

import com.example.usersbooking.dto.UserDto;
import com.example.usersbooking.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService _userService;

    public UserController(@Autowired IUserService service){
        this._userService = service;
    }

    @ApiOperation("Get all registered users")
    @ApiResponses({
        @ApiResponse(code = 200,message = "OK"),
        @ApiResponse(code = 500,message = "Error")
    })
    @GetMapping("/getAll")
    public ResponseEntity<Iterable<UserDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(_userService.getAll());
    }
}
