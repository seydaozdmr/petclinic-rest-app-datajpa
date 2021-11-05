package com.petclinic.rest.service;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<OwnerDto,Long> {
    OwnerDto findByLastName(String lastName);
    List<OwnerDto> findAllByLastNameLike(String lastName);
}
