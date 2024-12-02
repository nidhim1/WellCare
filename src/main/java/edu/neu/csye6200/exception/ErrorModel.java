package edu.neu.csye6200.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {

    private String code;
    private String message;
}