package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value={CustomException.class})
    public ResponseEntity<Object> CustomExceptionHandler(CustomException e){
        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }
}