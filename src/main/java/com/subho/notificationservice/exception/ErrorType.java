package com.subho.notificationservice.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    EMAIL_REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "All parameters not set for email request");

    private HttpStatus httpStatus;
    private String message;

    ErrorType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
