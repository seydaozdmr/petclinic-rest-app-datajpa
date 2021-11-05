package com.petclinic.rest.dto;

import com.petclinic.rest.model.Speciality;

import java.util.Set;

public class VetDto extends PersonDto implements BaseDto{
    public Set<SpecialityDto> specialities;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }
}
