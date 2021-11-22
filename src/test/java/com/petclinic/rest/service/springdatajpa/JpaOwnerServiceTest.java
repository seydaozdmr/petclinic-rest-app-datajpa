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
        owner=new Owner(1L,"seyda","Özdemir","asd","asdsa","asdasd",null);
    }

    @Test
    public void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        when(ownerMapper.toDTO(owner)).thenReturn(ownerDto);

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
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        when(ownerMapper.toDTO(owner)).thenReturn(ownerDto);
        OwnerDto dto=service.findById(1L);

        assertNotNull(dto);

    }


    @Test
    public void save(){
        when(ownerRepository.save(owner)).thenReturn(owner);
        when(ownerMapper.toSource(ownerDto)).thenReturn(owner);
        when(ownerMapper.toDTO(owner)).thenReturn(ownerDto);
        OwnerDto savedOwner=service.save(ownerDto);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }



    @Test
    void findAllByLastNameLike() {
        List<Owner> list=new ArrayList<>();
        list.add(new Owner(1L,"seyda","özdemir","asd","asdsa","asdasd",null));
        list.add(new Owner(2L,"seyda","özdemir","asd","asdsa","asdasd",null));

        when(ownerRepository.findAllByLastNameLike(any())).thenReturn(list);

        List<OwnerDto> result=service.findAllByLastNameLike("özdemir");

        assertEquals(2,result.size());
    }

    @Test
    void delete(){
        service.delete(ownerDto);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById(){
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

}