package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.PetDto;
import com.petclinic.rest.model.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PetMapper extends BasePageMapper<Pet,PetDto> {

}
