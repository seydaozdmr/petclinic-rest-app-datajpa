package com.petclinic.rest.dto;


import com.petclinic.rest.model.Pet;

import java.util.List;

public class OwnerDto extends PersonDto implements BaseDto {
    public String address;
    public String city;
    public String telephone;
    public List<Pet> pets;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }
}
