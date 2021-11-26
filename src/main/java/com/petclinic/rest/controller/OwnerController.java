package com.petclinic.rest.controller;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/owners")
public class OwnerController implements CommonController<OwnerDto>{

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public List<OwnerDto> getAll(){
        return ownerService.findAll();
    }

    @Override
    public OwnerDto find(Long id) {
        return ownerService.findById(id);
    }

    @Override
    public OwnerDto save(@Valid OwnerDto elem) {
        return ownerService.save(elem);
    }

    @Override
    public OwnerDto update(Long id, OwnerDto elem) {
        return ownerService.update(id,elem);
    }

    @Override
    public void deleteById(Long id) {
        ownerService.deleteById(id);
    }

    @Override
    public void delete(OwnerDto elem) {
        ownerService.delete(elem);
    }

    @GetMapping("/all")
    public List<OwnerDto> findOwnersAllLike(@RequestParam String lastName){
        return ownerService.findAllByLastNameLike(lastName);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

}
