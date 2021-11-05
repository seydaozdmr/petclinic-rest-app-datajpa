package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.mapper.SpecialityMapper;
import com.petclinic.rest.model.Speciality;
import com.petclinic.rest.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class SpecialityServiceImpl extends AbstractMapService<Speciality,SpecialityDto,Long> implements SpecialityService {

    public SpecialityServiceImpl(SpecialityMapper mapper) {
        super(mapper);
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
}
