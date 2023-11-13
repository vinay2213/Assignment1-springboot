package com.example.vinay.assignmentspringboot.exception;

public class ResourceNotFoundException extends RuntimeException {
    String message;
    public ResourceNotFoundException(String message) {
        super(String.format(message));
        this.message=message;
    }
}

