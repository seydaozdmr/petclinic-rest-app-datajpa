package com.petclinic.rest.service.map;

import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.exceptions.NoSuchAElementException;
import com.petclinic.rest.mapper.OwnerMapper;
import com.petclinic.rest.mapper.PetMapper;
import com.petclinic.rest.mapper.PetTypeMapper;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.model.Pet;
import com.petclinic.rest.service.OwnerService;
import com.petclinic.rest.service.PetService;
import com.petclinic.rest.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Profile("map")
public class OwnerServiceImpl extends AbstractMapService<Owner,OwnerDto,Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final PetTypeMapper petTypeMapper;
    private final PetMapper petMapper;

    public OwnerServiceImpl(OwnerMapper mapper, PetTypeService petTypeService, PetService petService, PetTypeMapper petTypeMapper, PetMapper petMapper) {
        super(mapper);
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.petTypeMapper = petTypeMapper;
        this.petMapper = petMapper;
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
        if(elem!=null){
            if(elem.pets!=null){
                elem.pets.forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeMapper.toSource(petTypeService.save(petTypeMapper.toDTO(pet.getPetType()))));
                        }
                    }else{
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId()==null){
                        Pet savedPet=petMapper.toSource(petService.save(petMapper.toDTO(pet)));
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(elem);
        }else
            return null;

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
        return myMap.values()
                .stream()
                .filter(elem->elem
                        .getLastName()
                        .equals(lastName))
                .findFirst().map(mapper::toDTO).orElseThrow(()->new NoSuchAElementException("Bu soyisminde eleman bulunamadı"));
    }

    @Override
    public List<OwnerDto> findAllByLastNameLike(String lastName) {
        return null;
    }
}
