package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.mapper.PersonMapper;
import com.petclinic.rest.mapper.VetMapper;
import com.petclinic.rest.model.Vet;
import com.petclinic.rest.repository.VetRepository;
import com.petclinic.rest.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class JpaVetService extends AbstractCommonService<Vet, VetDto,Long> implements VetService {
    public JpaVetService(VetRepository vetRepository, VetMapper mapper) {
        super(vetRepository, mapper);
    }
}
