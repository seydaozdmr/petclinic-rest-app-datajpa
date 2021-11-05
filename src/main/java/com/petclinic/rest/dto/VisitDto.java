package com.petclinic.rest.dto;

import java.time.LocalDate;

public class VisitDto implements BaseDto{
    public Long id;
    public LocalDate date;
    public String description;
    public PetDto pet;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
