package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.VisitDto;
import com.petclinic.rest.mapper.VisitMapper;
import com.petclinic.rest.model.Visit;
import com.petclinic.rest.repository.GenericRepository;
import com.petclinic.rest.repository.VisitRepository;
import com.petclinic.rest.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class JpaVisitService extends CommonService<Visit, VisitDto,Long> implements VisitService {
    public JpaVisitService(VisitRepository visitRepository, VisitMapper mapper) {
        super(visitRepository, mapper);
    }
}
