package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.mapper.SpecialityMapper;
import com.petclinic.rest.model.Speciality;
import com.petclinic.rest.repository.SpecialityRepository;
import com.petclinic.rest.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class JpaSpecialityService extends AbstractCommonService<Speciality, SpecialityDto,Long> implements SpecialityService {
    public JpaSpecialityService(SpecialityRepository specialityRepository, SpecialityMapper mapper) {
        super(specialityRepository, mapper);
    }
}
