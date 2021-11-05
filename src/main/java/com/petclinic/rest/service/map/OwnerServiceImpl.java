package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.mapper.OwnerMapper;
import com.petclinic.rest.mapper.OwnerMapperImpl;
import com.petclinic.rest.mapper.PersonMapper;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class OwnerServiceImpl extends AbstractMapService<Owner,OwnerDto,Long> implements OwnerService {

    public OwnerServiceImpl(OwnerMapper mapper) {
        super(mapper);
    }

    @Override
    public List<OwnerDto> findAll() {
        return super.findAll();
    }

    @Override
    public OwnerDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public OwnerDto save(OwnerDto elem) {
        return super.save(elem);
    }

    @Override
    public OwnerDto update(Long aLong, OwnerDto elem) {
        return super.update(aLong,elem);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(OwnerDto elem) {
        super.delete(elem);
    }

    @Override
    public OwnerDto findByLastName(String lastName) {
        return null;
//        return myMap.values()
//                .stream()
//                .filter(elem->elem.getLastName().equals(lastName)).findFirst().map(mapper::toDTO).get();
    }

    @Override
    public List<OwnerDto> findAllByLastNameLike(String lastName) {
        return null;
    }
}
