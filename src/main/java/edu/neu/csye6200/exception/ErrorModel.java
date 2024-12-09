package edu.neu.csye6200.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {

    private String code;
    private String message;

    // Default constructor
    public ErrorModel() {
    }

    // Constructor with parameters
    public ErrorModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}