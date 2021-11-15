package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.mapper.OwnerMapper;
import com.petclinic.rest.mapper.OwnerMapperImpl;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    Owner owner;

    @BeforeEach
    public void setUp() {
        ownerDto=new OwnerDto(1L,"seyda","Özdemir","asd","asdsa","asdasd",null);
        ownerMapper=new OwnerMapperImpl();
        owner=ownerMapper.toSource(ownerDto);
    }

    @Test
    public void findByLastName() {

        when(service.findByLastName(any())).thenReturn(ownerDto);

        OwnerDto ownerDto=service.findByLastName("Özdemir");

        assertEquals("Özdemir",ownerDto.getLastName());
        verify(ownerRepository,times(1)).findByLastName("Özdemir");
    }

    @Test
    void findAll() {
        List<Owner> list=new ArrayList<>();
        list.add(new Owner(1L,"seyda","özdemir","asd","asdsa","asdasd",null));
        list.add(new Owner(2L,"seyda","özdemir","asd","asdsa","asdasd",null));
        when(ownerRepository.findAll()).thenReturn(list); //repodan isteyince list'i ver
        List<OwnerDto> source=service.findAll(); //service'de sonuç olarak repodan istiyor...
        assertNotNull(source);
        assertEquals(2,source.size());
    }

    @Test
    public void findById(){
        //when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        when(ownerMapper.toDTO(owner)).thenReturn(ownerDto);
        OwnerDto ownerDto=service.findById(1L);


        assertNotNull(ownerDto);

    }

    @Test
    public void save(){
        when(service.save(any())).thenReturn(ownerDto);
        //when(ownerRepository.save(any())).thenReturn(owner);
        OwnerDto savedOwner=service.save(ownerDto);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }



    @Test
    void findAllByLastNameLike() {
    }
}