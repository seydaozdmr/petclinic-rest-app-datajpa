package com.petclinic.rest.controller;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.exceptions.NoSuchAElementException;
import com.petclinic.rest.exceptions.NoSuchElementAdvice;
import com.petclinic.rest.service.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    List<OwnerDto> ownerDtos;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ownerDtos=new ArrayList<>();
        ownerDtos.add(new OwnerDto(1L,"seyda","özdemir","adsad","asdasd","asdasd",null));
        ownerDtos.add(new OwnerDto(2L,"seyda","özdemir","adsad","asdasd","asdasd",null));

        mockMvc= MockMvcBuilders
                .standaloneSetup(ownerController)
                .setControllerAdvice(new NoSuchElementAdvice())
                .build();
    }

    @Test
    void getAll() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))

                .andExpect(jsonPath("$", Matchers.hasSize(2)));
        //List<OwnerDto> list=ownerController.getAll();

        //assertEquals(2,list.size());
    }

    @Test
    void find() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(new OwnerDto(1L,"seyda","özdemir","asdsa","asdasd","dasd",null));

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))

                .andExpect(jsonPath("$").exists());
    }

    @Test
    public void getOwnerByIdTestNotFound() throws Exception {
        //when(ownerMapper.toDTO(owner)).thenReturn(ownerDto);
//        Assertions.assertThrows(NoSuchAElementException.class, () -> {
//            service.findById(3L);
//        });

        when(ownerService.findById(anyLong())).thenThrow(NoSuchAElementException.class);

        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }
}