package com.petclinic.rest.service;

import com.petclinic.rest.dto.BaseDto;

import java.util.List;
import java.util.Set;

public interface CrudService <DTO extends BaseDto,ID>{

    DTO findById(ID id);
    DTO save(DTO elem);
    DTO update(ID id,DTO elem);
    List<DTO> findAll();
    void deleteById (ID id);
    void delete (DTO elem);


}
