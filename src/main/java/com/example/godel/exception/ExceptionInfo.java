package com.example.godel.exception;

import org.springframework.http.HttpStatus;

public class ExceptionInfo {
    private String error;

    private String message;

    private String detail;

    private HttpStatus httpStatus;

    public ExceptionInfo() {
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ExceptionInfo setError(String error) {
        this.error = error;
        return this;
    }

    public ExceptionInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public ExceptionInfo setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public ExceptionInfo setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    @Override
    public String toString() {
        return "ExceptionInfo{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", detail='" + detail + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
