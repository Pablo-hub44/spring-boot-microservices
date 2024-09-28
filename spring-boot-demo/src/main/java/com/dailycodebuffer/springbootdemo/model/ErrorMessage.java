package com.dailycodebuffer.springbootdemo.model;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private HttpStatus status;// para el status del http
    private String message;// el mensaje

    // setters y getters
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
