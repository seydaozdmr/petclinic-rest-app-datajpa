package com.petclinic.rest.service.springdatajpa;

import com.petclinic.rest.dto.BaseDto;
import com.petclinic.rest.mapper.BasePageMapper;
import com.petclinic.rest.model.BaseEntity;
import com.petclinic.rest.repository.GenericRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public abstract class AbstractCommonService<T extends BaseEntity,DTO extends BaseDto,ID extends Long> {
    protected final GenericRepository<T> genericRepository;
    protected final BasePageMapper<T, DTO> mapper;


    public AbstractCommonService(GenericRepository<T> genericRepository, BasePageMapper<T, DTO> mapper) {
        this.genericRepository = genericRepository;
        this.mapper = mapper;
    }

    public List<DTO> findAll(){
        System.out.println("data jpa is running");
        return genericRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public DTO findById(ID id){
        return genericRepository.findById(id).map(mapper::toDTO).orElseThrow(()-> new NoSuchElementException(id+" numaralı eleman bulunamamıştır"));
    }

    public DTO save(DTO elem){
        return mapper.toDTO(genericRepository.save(mapper.toSource(elem)));
    }

    public DTO update(ID id,DTO elem){
        return genericRepository.findById(id).map(e->{
            e=mapper.toSource(elem);
            return mapper.toDTO(genericRepository.save(e));
        }).orElseThrow(()->new NoSuchElementException("eleman bulunamadı"));
    }

    public void deleteById(ID id){
        genericRepository.deleteById(id);
    }

    public void delete(DTO elem){
        genericRepository.delete(mapper.toSource(elem));
    }
}
