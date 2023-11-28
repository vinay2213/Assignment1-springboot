package com.example.vinay.assignmentspringboot.exception;

import lombok.Getter;

@Getter
public class ApiResponse {
    private int status;
    private String message;
    private boolean success;
    private long timestamp;

    public ApiResponse() {

    }

    public ApiResponse(int status, String message, boolean success, long timestamp) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.timestamp = timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

