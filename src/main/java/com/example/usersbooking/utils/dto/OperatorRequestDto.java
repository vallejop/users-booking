package com.example.usersbooking.utils.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OperatorRequestDto {

    private final String PATTERN = "^[A-Za-z]*$";

    @NotEmpty
    @Pattern(regexp=PATTERN,message = "El parametro name no es válido")
    private String name;

    @NotEmpty
    @Pattern(regexp=PATTERN,message = "El parametro lastName no es válido")
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password debería contener al menos 8 caracteres")
    private String password;

    public OperatorRequestDto() {}

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
