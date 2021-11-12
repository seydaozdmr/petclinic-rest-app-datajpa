package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.mapper.OwnerMapperImpl;
import com.petclinic.rest.mapper.PetMapperImpl;
import com.petclinic.rest.mapper.PetTypeMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceImplTest {
    OwnerServiceImpl ownerService;

    @BeforeEach
    void setUp() {
        ownerService=new OwnerServiceImpl(new OwnerMapperImpl(),new PetTypeServiceImpl(new PetTypeMapperImpl()),new PetServiceImpl(new PetMapperImpl()),new PetTypeMapperImpl(),new PetMapperImpl());
        OwnerDto ownerDto=new OwnerDto();
        ownerDto.setId(1L);
        ownerService.save(ownerDto);

    }

    @Test
    void findAll() {
        List<OwnerDto> ownerDtos=ownerService.findAll();

        assertEquals(1,ownerDtos.size());
    }

    @Test
    void findById() {
        OwnerDto ownerDto=ownerService.findById(1L);

        assertEquals(1L,ownerDto.getId());
    }

    @Test
    void saveExistingId() {
        OwnerDto ownerDto=new OwnerDto();
        ownerDto.setId(1L);
        OwnerDto savedDto=ownerService.save(ownerDto);

        assertEquals(1L,savedDto.getId());
    }

    @Test
    void saveNoId(){
        OwnerDto ownerDto=new OwnerDto();
        OwnerDto savedDto=ownerService.save(ownerDto);
        assertNotNull(savedDto);
        assertNotNull(savedDto.getId());
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerService.findById(1L).getId());


    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(1L));

        assertEquals(0,ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findAllByLastNameLike() {
    }
}