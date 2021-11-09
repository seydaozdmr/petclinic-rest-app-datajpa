package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.mapper.SpecialityMapper;
import com.petclinic.rest.mapper.VetMapper;
import com.petclinic.rest.model.Speciality;
import com.petclinic.rest.model.Vet;
import com.petclinic.rest.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("map")
public class SpecialityServiceImpl extends AbstractMapService<Speciality,SpecialityDto,Long> implements SpecialityService {

    private final VetMapper vetMapper;
    public SpecialityServiceImpl(SpecialityMapper mapper, VetMapper vetMapper) {
        super(mapper);
        this.vetMapper = vetMapper;
    }

    @Override
    public SpecialityDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public SpecialityDto save(SpecialityDto elem) {
        return super.save(elem);
    }

    @Override
    public SpecialityDto update(Long id, SpecialityDto elem) {
        return super.update(id,elem);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(SpecialityDto elem) {
        super.delete(elem);
    }

    @Override
    public List<VetDto> findAllVetsBySpeciality(String description) {
        List<Vet> myList=myMap.values().stream().filter(el->el.getDescription().equals(description)).map(e->e.getVet()).findAny().get();
        return myList.stream().map(vetMapper::toDTO).collect(Collectors.toList());
    }
}
