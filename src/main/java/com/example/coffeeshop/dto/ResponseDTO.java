package com.example.coffeeshop.dto;

import org.springframework.http.HttpStatus;

public class ResponseDTO {

    private HttpStatus status;
    private String message;
    private Object data;
    private Boolean error = false;

    public ResponseDTO(HttpStatus status) {
        this.status = status;
    }

    public ResponseDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseDTO(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(HttpStatus status, String message, Object data, Boolean error) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.error = error;
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

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
