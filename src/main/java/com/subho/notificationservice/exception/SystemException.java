package com.subho.notificationservice.exception;

import org.springframework.http.HttpStatus;

public class SystemException extends Exception {
    private HttpStatus httpStatus;
    private String message;
    private Object data;
    private ErrorType errorType;


    public SystemException(Throwable cause, ErrorType errorType) {
        super(cause);
        this.errorType = errorType;
        httpStatus = errorType.getHttpStatus();
        message = errorType.getMessage();
    }

    public SystemException(ErrorType errorType) {
        this.errorType = errorType;
        httpStatus = errorType.getHttpStatus();
        message = errorType.getMessage();
    }

    public SystemException(ErrorType errorType, Object data) {
        this.errorType = errorType;
        httpStatus = errorType.getHttpStatus();
        message = errorType.getMessage();
        this.data = data;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
