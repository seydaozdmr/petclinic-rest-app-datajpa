package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.VisitDto;
import com.petclinic.rest.mapper.VisitMapper;
import com.petclinic.rest.model.Visit;
import com.petclinic.rest.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VisitServiceImpl extends AbstractMapService<Visit, VisitDto,Long> implements VisitService {
    public VisitServiceImpl(VisitMapper mapper) {
        super(mapper);
    }

    @Override
    public VisitDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VisitDto save(VisitDto elem) {
        return super.save(elem);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(VisitDto elem) {
        super.delete(elem);
    }

    @Override
    public VisitDto update(Long id, VisitDto elem) {
        return super.update(id,elem);
    }
}
