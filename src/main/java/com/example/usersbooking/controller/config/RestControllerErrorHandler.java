package com.example.usersbooking.controller.config;

import com.example.usersbooking.utils.dto.ParameterErrorResponseDto;
import com.example.usersbooking.utils.dto.ServerErrorResponseDto;
import com.example.usersbooking.utils.errors.InternalServerErrorException;
import com.example.usersbooking.utils.errors.InvalidParameterErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.security.InvalidParameterException;

@RestControllerAdvice
public class RestControllerErrorHandler {
    @ExceptionHandler( HttpMessageNotReadableException.class )
    private ResponseEntity<String> handleHTTPMessageNotReadable(HttpMessageNotReadableException exception )
    {
        return new ResponseEntity<>( exception.getCause().getMessage(), HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler( MissingServletRequestPartException.class )
    private ResponseEntity<String> handleMissingServletRequestPart( MissingServletRequestPartException exception )
    {
        return new ResponseEntity<>( exception.getCause().getMessage(), HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler( InternalServerErrorException.class )
    private ResponseEntity<ServerErrorResponseDto> handleRuntimeException(InternalServerErrorException exception )
    {
        return new ResponseEntity<>( exception.getServerErrorResponseDto(), exception.getHttpStatus() );
    }

    @ExceptionHandler( InvalidParameterException.class )
    private ResponseEntity<ParameterErrorResponseDto> invalidParameterException(InvalidParameterErrorException exception )
    {
        return new ResponseEntity<>( exception.getParameterErrorResponseDto(), HttpStatus.CONFLICT);
    }
}
