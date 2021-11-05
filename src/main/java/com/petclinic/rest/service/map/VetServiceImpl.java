package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.mapper.PersonMapper;
import com.petclinic.rest.mapper.VetMapper;
import com.petclinic.rest.model.Vet;
import com.petclinic.rest.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VetServiceImpl extends AbstractMapService<Vet, VetDto,Long> implements VetService {
    public VetServiceImpl(VetMapper mapper) {
        super(mapper);
    }

    @Override
    public VetDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VetDto save(VetDto elem) {
        return super.save(elem);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(VetDto elem) {
        super.delete(elem);
    }

    @Override
    public VetDto update(Long id, VetDto elem) {
        return super.update(id,elem);
    }
}
