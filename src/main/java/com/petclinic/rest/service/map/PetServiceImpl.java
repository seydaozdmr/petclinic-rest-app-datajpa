package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.PetDto;
import com.petclinic.rest.mapper.PetMapper;
import com.petclinic.rest.model.Pet;
import com.petclinic.rest.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("map")
public class PetServiceImpl extends AbstractMapService<Pet, PetDto,Long> implements PetService {

    public PetServiceImpl(PetMapper mapper) {
        super(mapper);
    }

    @Override
    public PetDto update(Long id, PetDto elem) {
        return super.update(id,elem);
    }

    @Override
    public List<PetDto> findAll() {
        List<PetDto> myList=new ArrayList<>(super.findAll());
        Collections.sort(myList,(a, b)->{
            if(a.getId()>b.getId())
                return 1;
            else if(a.getId()<b.getId())
                return -1;
            return 0;

        });
        return myList;
    }

    @Override
    public PetDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetDto save(PetDto elem) {
        return super.save(elem);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetDto elem) {
        super.delete(elem);
    }
}
