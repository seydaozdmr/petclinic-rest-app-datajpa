package com.petclinic.rest.controller;

import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.service.SpecialityService;
import com.petclinic.rest.service.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vets")
public class VetController implements CommonController<VetDto>{
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @Override
    public List<VetDto> getAll() {
        return vetService.findAll();
    }

    @Override
    public VetDto find(Long id) {
        return vetService.findById(id);
    }

    @Override
    public VetDto save(VetDto elem) {
        return vetService.save(elem);
    }

    @Override
    public VetDto update(Long id, VetDto elem) {
        return vetService.update(id,elem);
    }

    @Override
    public void deleteById(Long id) {
        vetService.deleteById(id);
    }

    @Override
    public void delete(VetDto elem) {
        vetService.delete(elem);
    }

}
