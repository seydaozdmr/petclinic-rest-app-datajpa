package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.PetTypeDto;
import com.petclinic.rest.mapper.PetTypeMapper;
import com.petclinic.rest.model.PetType;
import com.petclinic.rest.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class PetTypeServiceImpl extends AbstractMapService<PetType, PetTypeDto,Long> implements PetTypeService {

    public PetTypeServiceImpl(PetTypeMapper mapper) {
        super(mapper);
    }

    @Override
    public List<PetTypeDto> findAll() {
        return super.findAll();
    }

    @Override
    public PetTypeDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetTypeDto save(PetTypeDto elem) {
        return super.save(elem);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetTypeDto elem) {
        super.delete(elem);
    }

    @Override
    public PetTypeDto update(Long id, PetTypeDto elem) {
        return super.update(id,elem);
    }
}
