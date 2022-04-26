package com.example.usersbooking.utils.errors;

import com.example.usersbooking.utils.dto.ParameterErrorResponseDto;
import org.springframework.http.HttpStatus;

import java.security.InvalidParameterException;

public class InvalidParameterErrorException extends InvalidParameterException {

    private final ParameterErrorResponseDto parameterErrorResponseDto;
    private final HttpStatus httpStatus;

    public InvalidParameterErrorException(ParameterErrorResponseDto parameterErrorResponseDto, HttpStatus httpStatus) {
        this.parameterErrorResponseDto = parameterErrorResponseDto;
        this.httpStatus = httpStatus;
    }

    public ParameterErrorResponseDto getParameterErrorResponseDto() {
        return parameterErrorResponseDto;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}