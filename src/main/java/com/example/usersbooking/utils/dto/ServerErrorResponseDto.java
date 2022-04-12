package com.example.usersbooking.utils.dto;

import com.example.usersbooking.utils.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class ServerErrorResponseDto {
    private String message;
    private ErrorCode errorCode;
    private int httpStatus;

    public ServerErrorResponseDto(String message, ErrorCode errorCode, HttpStatus httpStatus) {
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.value();
    }
}
