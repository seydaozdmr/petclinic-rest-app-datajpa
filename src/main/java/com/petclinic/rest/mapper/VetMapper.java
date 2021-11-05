package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.model.Vet;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface VetMapper extends BasePageMapper<Vet,VetDto> {


}
