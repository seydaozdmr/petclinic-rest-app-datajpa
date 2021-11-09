package com.petclinic.rest.controller;

import com.petclinic.rest.dto.SpecialityDto;
import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.service.SpecialityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController implements CommonController<SpecialityDto> {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public List<SpecialityDto> getAll() {
        return specialityService.findAll();
    }

    @Override
    public SpecialityDto find(Long id) {
        return specialityService.findById(id);
    }

    @Override
    public SpecialityDto save(SpecialityDto elem) {
        return specialityService.save(elem);
    }

    @Override
    public SpecialityDto update(Long id, SpecialityDto elem) {
        return specialityService.update(id,elem);
    }

    @Override
    public void deleteById(Long id) {
        specialityService.deleteById(id);
    }

    @Override
    public void delete(SpecialityDto elem) {
        specialityService.delete(elem);
    }

    @GetMapping("/vets")
    public List<VetDto> getAllVetsBySpeciality(@RequestParam String description){
        return specialityService.findAllVetsBySpeciality(description);
    }
}
