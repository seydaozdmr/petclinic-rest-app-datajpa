package com.petclinic.rest.controller;

import com.petclinic.rest.dto.PetDto;
import com.petclinic.rest.model.Pet;
import com.petclinic.rest.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class PetController {
    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<PetDto> findAll(){
        return petService.findAll();
    }

    @GetMapping("/pets/{id}")
    public PetDto findPetById(@PathVariable Long id){
        return petService.findById(id);
    }

    @PostMapping("/pets")
    public PetDto savePet(@RequestBody PetDto pet){
        return petService.save(pet);
    }

    @PutMapping("/pets/{id}")
    public PetDto updatePet(@PathVariable Long id,@RequestBody PetDto pet){
        return petService.update(id,pet);
    }

    @DeleteMapping("/pets/{id}")
    public void deleteById(@PathVariable Long id){
        petService.deleteById(id);
    }

    @DeleteMapping("/pets")
    public void deletePet(@RequestBody PetDto pet){
        petService.delete(pet);
    }

}
