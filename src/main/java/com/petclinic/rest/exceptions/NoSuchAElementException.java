package com.petclinic.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchAElementException extends RuntimeException{
    public NoSuchAElementException(){
        super();
    };
    public NoSuchAElementException(String message) {
        super(message);
    }
}
