package com.example.usersbooking.utils.exceptions;

import com.example.usersbooking.utils.dto.ServerErrorResponseDto;
import com.example.usersbooking.utils.enums.ErrorCode;
import com.example.usersbooking.utils.errors.InternalServerErrorException;
import com.example.usersbooking.utils.errors.MessageError;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException {
    public InvalidCredentialsException() {
        super(new ServerErrorResponseDto(MessageError.INVALID_CREDENTIALS, ErrorCode.INVALID_USER_CREDETIALS,
                HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
    }
}
