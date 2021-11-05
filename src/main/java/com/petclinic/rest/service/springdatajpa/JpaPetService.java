package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.PetDto;
import com.petclinic.rest.mapper.PetMapper;
import com.petclinic.rest.model.Pet;
import com.petclinic.rest.repository.PetRepository;
import com.petclinic.rest.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Profile("springdatajpa")
public class JpaPetService extends CommonService<Pet, PetDto,Long> implements PetService {
    public JpaPetService(PetRepository petRepository, PetMapper mapper) {
        super(petRepository, mapper);
    }

}
