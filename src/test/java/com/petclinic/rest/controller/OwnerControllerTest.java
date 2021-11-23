package com.petclinic.rest.controller;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.w3c.dom.stylesheets.LinkStyle;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
                .build();
    }

    @Test
    void getAll() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(MockMvcResultMatchers.status().is(200));
        //List<OwnerDto> list=ownerController.getAll();

        //assertEquals(2,list.size());
    }

    @Test
    void find() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(new OwnerDto(1L,"seyda","özdemir","asdsa","asdasd","dasd",null));

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
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