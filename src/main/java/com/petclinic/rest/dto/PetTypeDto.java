package com.petclinic.rest.dto;

public class PetTypeDto implements BaseDto{
    public Long id;
    public String name;


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
