package com.petclinic.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.exceptions.CustomGlobalExceptionHandler;
import com.petclinic.rest.exceptions.NoSuchAElementException;
import com.petclinic.rest.exceptions.NoSuchElementAdvice;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.service.OwnerService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.*;
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

    ObjectMapper objectMapper;

    List<OwnerDto> ownerDtos;

    OwnerDto ownerDto;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ownerDtos=new ArrayList<>();
        ownerDtos.add(new OwnerDto(1L,"seyda","özdemir","adsad","asdasd","asdasd",null));
        ownerDtos.add(new OwnerDto(2L,"seyda","özdemir","adsad","asdasd","asdasd",null));

        ownerDto=new OwnerDto(1L,"seyda","özdemir","adsad","asdasd","asdasd",null);

        objectMapper=new ObjectMapper();
        mockMvc= MockMvcBuilders
                .standaloneSetup(ownerController)
                .setControllerAdvice(new NoSuchElementAdvice())
                .setControllerAdvice(new CustomGlobalExceptionHandler())
                .build();
    }

    @Test
    void getAll() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners")
                .accept(MediaType.APPLICATION_JSON)
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
    void getOwnerByIdNumberFormatException() throws Exception {

        mockMvc.perform(get("/owners/adsad"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
        //MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String ownerDto = "{\"name\": \"bob\", \"lastName\" : \"Yıldırım\",\"address\" : \"Yıldırım\",\"city\" : \"Yıldırım\",\"telephone\" : \"Yıldırım\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/owners")
                .content(ownerDto)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {
        String ownerDto = "{\"name\": \"bob\", \"lastName\" : \"Yıldırım\",\"address\" : \"\",\"city\" : \"Yıldırım\",\"telephone\" : \"Yıldırım\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/owners")
                .content(ownerDto)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.status", Is.is(400)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", hasItem("adres boş")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void processFindFormEmptyReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(ownerDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/all").param("lastName","").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    void saveAsStringValue() throws Exception {
        String ownerDto = "{\"name\": \"bob\", \"lastName\" : \"Yıldırım\",\"address\" : \" asd\",\"city\" : \"Yıldırım\",\"telephone\" : \"Yıldırım\"}";

        when(ownerService.save(any())).thenReturn(this.ownerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/owners")
                .content(ownerDto)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", Is.is("seyda")));
    }
    @Test
    void save() throws Exception {
        when(ownerService.save(ownerDto)).thenReturn(ownerDto);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/owners")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(ownerDto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", Is.is("seyda")));
    }

    @Test
    void update() throws Exception {
        ownerDto.setName("hasan");
        when(ownerService.update(anyLong(),any())).thenReturn(ownerDto);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.put("/owners/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(ownerDto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", Is.is("hasan")));
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }
}