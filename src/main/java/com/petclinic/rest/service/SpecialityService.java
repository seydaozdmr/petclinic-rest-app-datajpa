package com.petclinic.rest.service;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.model.Speciality;
import com.petclinic.rest.model.Vet;

import java.util.List;

public interface SpecialityService extends CrudService<SpecialityDto,Long> {
    List<VetDto> findAllVetsBySpeciality(String description);
}
