package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.exceptions.NoSuchAElementException;
import com.petclinic.rest.mapper.OwnerMapperImpl;
import com.petclinic.rest.mapper.PetMapperImpl;
import com.petclinic.rest.mapper.PetTypeMapperImpl;
import org.junit.jupiter.api.Assertions;
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
        ownerDto.setLastName("özdemir");
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
        OwnerDto ownerDto=ownerService.findById(1L);
        ownerDto.setName("hasan");
        OwnerDto updatedDto=ownerService.update(ownerDto.getId(),ownerDto);

        assertEquals("hasan",updatedDto.getName());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        assertEquals(0,ownerService.findAll().size());

    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(1L));

        assertEquals(0,ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        OwnerDto dto=ownerService.findByLastName("özdemir");

        assertNotNull(dto);
        System.out.println(dto);
        assertEquals("özdemir",dto.getLastName());
    }

    @Test
    void findLastNameNotFound(){
        NoSuchAElementException thrown =assertThrows(NoSuchAElementException.class,()->{
            ownerService.findByLastName("foo");
        },"Bu soyisminde eleman bulunamadı");
        Assertions.assertEquals("Bu soyisminde eleman bulunamadı",thrown.getMessage());
    }

    @Test
    void findAllByLastNameLike() {
        List<OwnerDto> ownerDtos=ownerService.findAllByLastNameLike("özdemir");

        assertEquals(1,ownerDtos.size());
    }
}