package com.example.usersbooking.utils.exceptions;

import com.example.usersbooking.utils.dto.ParameterErrorResponseDto;
import com.example.usersbooking.utils.enums.ErrorCode;
import com.example.usersbooking.utils.errors.InvalidParameterErrorException;
import com.example.usersbooking.utils.errors.MessageError;
import org.springframework.http.HttpStatus;

public class InvalidParameterException extends InvalidParameterErrorException {
    public InvalidParameterException(String myMessage) {
        super(new ParameterErrorResponseDto(MessageError.INVALID_PARAMETERS + myMessage, ErrorCode.INVALID_PARAMETERS), HttpStatus.CONFLICT);
    }
}
