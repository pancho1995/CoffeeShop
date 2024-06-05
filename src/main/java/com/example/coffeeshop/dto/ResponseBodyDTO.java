package com.example.coffeeshop.dto;

import org.springframework.http.HttpStatus;

public class ResponseBodyDTO {

    private HttpStatus status;
    private String message;
    private Object data;

    public ResponseBodyDTO(HttpStatus status) {
        this.status = status;
    }

    public ResponseBodyDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseBodyDTO(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}