package com.example.usersbooking.dto;

import java.util.Date;

public class UserDto {
    private String name;
    private Boolean active;
    private Date until;
    private Integer age;
    private String email;
    private Long phone;
    private String profession;

    public UserDto() {}

    public UserDto(String name, Boolean active, Date until, Integer age, String email, Long phone, String profession) {
        this.name = name;
        this.active = active;
        this.until = until;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.profession = profession;
    }
}
