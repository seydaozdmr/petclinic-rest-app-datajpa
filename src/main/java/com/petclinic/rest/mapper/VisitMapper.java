package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.VisitDto;
import com.petclinic.rest.model.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface VisitMapper extends BasePageMapper<Visit, VisitDto> {
}
