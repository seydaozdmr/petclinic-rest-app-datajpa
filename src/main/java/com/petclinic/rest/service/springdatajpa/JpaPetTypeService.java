package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.PetTypeDto;
import com.petclinic.rest.mapper.PetTypeMapper;
import com.petclinic.rest.model.PetType;
import com.petclinic.rest.repository.PetTypeRepository;
import com.petclinic.rest.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class JpaPetTypeService extends AbstractCommonService<PetType, PetTypeDto,Long> implements PetTypeService {
    public JpaPetTypeService(PetTypeRepository petTypeRepository, PetTypeMapper mapper) {
        super(petTypeRepository, mapper);
    }

}
