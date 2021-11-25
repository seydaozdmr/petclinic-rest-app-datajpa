package com.petclinic.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class NoSuchElementAdvice {

    @ResponseBody
    @ExceptionHandler(NoSuchAElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchElement(NoSuchAElementException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String numberFormatException(NumberFormatException e){
        return e.getMessage()+" istek hatası";
    }


}
