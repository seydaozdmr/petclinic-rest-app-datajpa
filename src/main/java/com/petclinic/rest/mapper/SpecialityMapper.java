package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.model.Speciality;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface SpecialityMapper extends BasePageMapper<Speciality, SpecialityDto> {
}
