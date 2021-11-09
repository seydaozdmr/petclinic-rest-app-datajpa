package com.petclinic.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoSuchElementAdvice {

    @ResponseBody
    @ExceptionHandler(NoSuchAElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchElement(NoSuchAElementException e){
        return e.getMessage();
    }

}
