package com.petclinic.rest.dto;

public class SpecialityDto implements BaseDto{
    public Long id;
    public String description;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
