package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.exceptions.NoSuchAElementException;
import com.petclinic.rest.mapper.SpecialityMapper;
import com.petclinic.rest.mapper.VetMapper;
import com.petclinic.rest.model.Speciality;
import com.petclinic.rest.repository.SpecialityRepository;
import com.petclinic.rest.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Profile("springdatajpa")
public class JpaSpecialityService extends AbstractCommonService<Speciality, SpecialityDto,Long> implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    private final VetMapper vetMapper;
    public JpaSpecialityService(SpecialityRepository specialityRepository, SpecialityMapper mapper, VetMapper vetMapper) {
        super(specialityRepository, mapper);
        this.specialityRepository=specialityRepository;
        this.vetMapper = vetMapper;
    }

    @Override
    public List<VetDto> findAllVetsBySpeciality(String description) {
        return specialityRepository.findAllByDescription(description)
                .stream()
                .map(e->e.getVet())
                .findAny().orElseThrow(()->new NoSuchAElementException("eleman bulunamadı"))
                .stream()
                .map(vetMapper::toDTO)
                .collect(Collectors.toList());
    }
}
