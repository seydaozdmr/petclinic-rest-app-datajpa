package com.petclinic.rest.dto;


public class PersonDto implements BaseDto{
    public Long id;
    public String name;
    public String lastName;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
