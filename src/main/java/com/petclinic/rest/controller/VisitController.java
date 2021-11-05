package com.petclinic.rest.controller;

import com.petclinic.rest.dto.VisitDto;
import com.petclinic.rest.model.Visit;
import com.petclinic.rest.service.VisitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController implements CommonController<VisitDto> {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public List<VisitDto> getAll() {
        return visitService.findAll();
    }

    @Override
    public VisitDto find(Long id) {
        return visitService.findById(id);
    }

    @Override
    public VisitDto save(VisitDto elem) {
        return visitService.save(elem);
    }

    @Override
    public VisitDto update(Long id, VisitDto elem) {
        return visitService.update(id,elem);
    }

    @Override
    public void deleteById(Long id) {
        visitService.deleteById(id);
    }

    @Override
    public void delete(VisitDto elem) {
        visitService.delete(elem);
    }
}
