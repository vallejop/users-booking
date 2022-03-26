package com.example.usersbooking.controller;

import com.example.usersbooking.dto.UserDto;
import com.example.usersbooking.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
        @ApiResponse(code = 204,message = "No users registered"),
        @ApiResponse(code = 500,message = "Error")
    })
    @GetMapping("/getAll")
    public ResponseEntity<Iterable<UserDto>> getAll(){
        Collection<UserDto> users = (Collection<UserDto>)_userService.getAll();
        return ResponseEntity.status(users.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK)
                .body(users);
    }

    @ApiOperation("Get user by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message="OK"),
            @ApiResponse(code = 404,message = "User not found"),
            @ApiResponse(code=500,message = "Error in server")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> GetUserById(@PathVariable String id){
        UserDto user = _userService.getById(id);
        return ResponseEntity.status(user !=null? HttpStatus.OK:HttpStatus.NOT_FOUND).body(user);
    }

    @ApiOperation("Update an user")
    @ApiResponses({
            @ApiResponse(code=200,message="OK"),
            @ApiResponse(code=204,message = "Not is user")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> UpdateUser(@RequestBody UserDto user,@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(_userService.updateSuscription(user,id));
    }
}
