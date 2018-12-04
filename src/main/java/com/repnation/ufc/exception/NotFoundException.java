package com.repnation.ufc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(String property, Long value) {
        super("It was not possible to find " + property + " with id " + value);
    }
}
