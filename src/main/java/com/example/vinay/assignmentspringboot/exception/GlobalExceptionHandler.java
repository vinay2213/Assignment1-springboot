package com.example.vinay.assignmentspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundException.class)
    @ExceptionHandler
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e)
    {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiResponse.setMessage(e.getMessage());
        apiResponse.setSuccess(false);
        apiResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(Exception e)
    {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        apiResponse.setMessage(e.getMessage());
        apiResponse.setSuccess(false);
        apiResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
