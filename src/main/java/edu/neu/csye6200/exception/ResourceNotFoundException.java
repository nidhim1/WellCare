package edu.neu.csye6200.exception;

import java.util.Collections;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String message) {
        super(Collections.singletonList(new ErrorModel("NOT_FOUND", message)));
    }
}
