package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.mapper.OwnerMapper;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JpaOwnerServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    OwnerMapper ownerMapper;

    @InjectMocks
    JpaOwnerService service;

    OwnerDto ownerDto;

    @BeforeEach
    void setUp() {
        ownerDto=new OwnerDto(1L,"seyda","özdemir","asd","asdsa","asdasd",null);
    }

    @Test
    void findByLastName() {

        when(service.findByLastName(any())).thenReturn(ownerDto);

        OwnerDto ownerDto=service.findByLastName("Özdemir");

        assertEquals("Özdemir",ownerDto.getLastName());
        verify(ownerRepository,times(1)).findByLastName("Özdemir");
    }

    @Test
    void findAll() {
        List<OwnerDto> list=List.of(new OwnerDto(1L,"seyda","özdemir","asd","asdsa","asdasd",null),new OwnerDto(2L,"seyda","özdemir","asd","asdsa","asdasd",null));
        when(ownerRepository.findAll().stream().map(ownerMapper::toDTO).collect(Collectors.toList())).thenReturn(list);
        List<OwnerDto> source=service.findAll();
        assertEquals(2,source.size());
    }

    @Test
    void findAllByLastNameLike() {
    }
}