package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.mapper.OwnerMapper;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.repository.OwnerRepository;
import com.petclinic.rest.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Profile("springdatajpa")
public class JpaOwnerService extends CommonService<Owner, OwnerDto,Long> implements OwnerService {
    private final OwnerRepository ownerRepository;

    public JpaOwnerService(OwnerRepository ownerRepository, OwnerMapper mapper) {
        super(ownerRepository, mapper);
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDto findByLastName(String lastName) {
        return mapper.toDTO(ownerRepository.findByLastName(lastName));
    }

    @Override
    public List<OwnerDto> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
