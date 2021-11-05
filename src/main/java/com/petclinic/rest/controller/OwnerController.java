package com.petclinic.rest.controller;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController implements CommonController<OwnerDto>{

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public List<OwnerDto> getAll(){
        return ownerService.findAll();
    }

    @Override
    public OwnerDto find(Long id) {
        return ownerService.findById(id);
    }

    @Override
    public OwnerDto save(OwnerDto elem) {
        return ownerService.save(elem);
    }

    @Override
    public OwnerDto update(Long id, OwnerDto elem) {
        return ownerService.update(id,elem);
    }

    @Override
    public void deleteById(Long id) {
        ownerService.deleteById(id);
    }

    @Override
    public void delete(OwnerDto elem) {
        ownerService.delete(elem);
    }

}
