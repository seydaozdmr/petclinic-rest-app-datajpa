package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.BaseDto;
import com.petclinic.rest.mapper.BasePageMapper;
import com.petclinic.rest.mapper.PersonMapper;
import com.petclinic.rest.model.BaseEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMapService<T extends BaseEntity,DTO extends BaseDto,ID extends Long> {
    protected Map<Long,T> myMap=new HashMap<>();
    protected final BasePageMapper<T,DTO> mapper;

    protected AbstractMapService(BasePageMapper<T, DTO> mapper) {
        this.mapper = mapper;
    }


    public List<DTO> findAll(){
        System.out.println("map is running");
        return new ArrayList<>(myMap.values().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

    DTO findById(Long id){
        return mapper.toDTO(myMap.get(id));
    }

    DTO save(DTO elem){
        if(elem!=null){
            if(elem.getId()==null){
                elem.setId(generateId());
            }
            myMap.put(elem.getId(), mapper.toSource(elem));
        }else {
            throw new RuntimeException("Object cannot be null");
        }
        return elem;
    }

    DTO update(Long id,DTO elem){
        if(elem!=null){
            myMap.put(id,mapper.toSource(elem));
        }else{
            throw new RuntimeException("Object is null");
        }
        return elem;
    }

    void deleteById(Long id){
        myMap.remove(id);
    }

    void delete(DTO t){
        myMap.entrySet().removeIf(e->e.equals(mapper.toSource(t)));
    }

    private Long generateId(){
        Long nextId=null;
        try{
            nextId= Collections.max(myMap.keySet()) + 1 ;
        }catch (NoSuchElementException e){
            nextId=1L;
        }
        return nextId;
    }
}
