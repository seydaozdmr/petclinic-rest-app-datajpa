package com.petclinic.rest.service;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.mapper.OwnerMapper;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class OwnerServiceIT {
    @Autowired
    OwnerService ownerService;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    OwnerMapper ownerMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void savedName(){
        //given
        Iterable<Owner> owners=ownerRepository.findAll();
        Owner owner=owners.iterator().next();
        OwnerDto ownerDto=ownerMapper.toDTO(owner);

        //when
        ownerDto.setName("Hasan");
        OwnerDto savedOwner=ownerService.save(ownerDto);

        //then
        assertEquals("Hasan",savedOwner.getName());
    }

    @Test
    void findByLastName() {
        Owner owner=ownerRepository.findByLastName("Özdemir");

        OwnerDto ownerDto1=ownerService.findByLastName("Özdemir");

        assertEquals(owner.getName(),ownerDto1.getName());

    }

    @Test
    void findAllByLastNameLike() {
    }
}