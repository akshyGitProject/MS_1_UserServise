package com.example.MS_1_UserServise.exceptions;

import com.example.MS_1_UserServise.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourseNotFoundException(ResourseNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }
}
