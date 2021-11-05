package com.petclinic.rest.dto;

import com.petclinic.rest.model.Owner;
import com.petclinic.rest.model.PetType;
import com.petclinic.rest.model.Visit;

import java.time.LocalDate;
import java.util.Set;

public class PetDto implements BaseDto {
    public Long id;
    public String name;
    public PetType petType;
    public Owner owner;
    public LocalDate localDate;
    public Set<Visit> visits;

    @Override
    public Long getId() {
        return this.id=id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
