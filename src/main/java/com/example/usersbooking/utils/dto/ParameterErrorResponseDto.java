package com.example.usersbooking.utils.dto;

import com.example.usersbooking.utils.enums.ErrorCode;

public class ParameterErrorResponseDto {
    private String message;
    private ErrorCode errorCode;

    public ParameterErrorResponseDto(String message, ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
