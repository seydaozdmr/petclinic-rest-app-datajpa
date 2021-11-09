package com.petclinic.rest.exceptions;

public class NoSuchAElementException extends RuntimeException{
    public NoSuchAElementException(String message) {
        super(message);
    }
}
