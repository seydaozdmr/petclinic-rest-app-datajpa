package com.petclinic.rest.mapper;


import com.petclinic.rest.dto.BaseDto;
import com.petclinic.rest.model.BaseEntity;


public interface BasePageMapper <S extends BaseEntity,DTO extends BaseDto> {
    S toSource(DTO dto);

    DTO toDTO(S source);

}
