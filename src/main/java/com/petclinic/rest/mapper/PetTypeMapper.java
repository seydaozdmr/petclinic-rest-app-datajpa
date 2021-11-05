package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.PetTypeDto;
import com.petclinic.rest.model.PetType;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PetTypeMapper extends BasePageMapper<PetType, PetTypeDto> {
}
