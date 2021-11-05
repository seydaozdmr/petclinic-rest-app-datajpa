package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface OwnerMapper extends BasePageMapper<Owner,OwnerDto>{

}
