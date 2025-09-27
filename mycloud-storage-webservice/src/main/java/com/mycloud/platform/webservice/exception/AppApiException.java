package com.mycloud.platform.webservice.exception;

import org.springframework.http.HttpStatus;

public class AppApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public AppApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public AppApiException(String message1,HttpStatus status, String message2) {
        super(message1);
        this.status = status;
        this.message = message2;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
