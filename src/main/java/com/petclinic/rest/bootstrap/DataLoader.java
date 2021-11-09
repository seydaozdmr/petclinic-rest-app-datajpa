package com.petclinic.rest.bootstrap;

import com.petclinic.rest.mapper.*;
import com.petclinic.rest.model.*;
import com.petclinic.rest.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final VetService vetService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    private final PetMapper petMapper;
    private final PetTypeMapper petTypeMapper;
    private final OwnerMapper ownerMapper;
    private final VetMapper vetMapper;
    private final SpecialityMapper specialityMapper;
    private final VisitMapper visitMapper;

    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, PetService petService, VetService vetService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petMapper = new PetMapperImpl();
        this.petTypeMapper = new PetTypeMapperImpl();
        this.ownerMapper = new OwnerMapperImpl();
        this.vetMapper = new VetMapperImpl();
        this.specialityMapper=new SpecialityMapperImpl();
        this.visitMapper=new VisitMapperImpl();
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType=new PetType(1L,"Kedi");
        PetType petType2=new PetType(2L,"Köpek");

        petTypeService.save(petTypeMapper.toDTO(petType));
        petTypeService.save(petTypeMapper.toDTO(petType2));

        Owner owner=new Owner(1L,"Seyda","Özdemir","Burdur","Burdur","555",null);
        Owner owner1=new Owner(2L,"Ali","Yılmaz","Antalya","Antalya","222",null );
        System.out.println(ownerService.save(ownerMapper.toDTO(owner)));
        System.out.println(ownerService.save(ownerMapper.toDTO(owner1)));



        Pet pet=new Pet(1L,"Tekir",petType,owner, LocalDate.of(2015,5,10),null);
        Pet pet2=new Pet(2L,"Yaz",petType2,owner1,LocalDate.of(2020,1,1),null);
        owner.addPet(pet);
        owner1.addPet(pet2);

        //TODO mapstruct dan dolayı owner's pets set edilmiyor...
        ownerService.save(ownerMapper.toDTO(owner));
        ownerService.save(ownerMapper.toDTO(owner1));


        petService.save(petMapper.toDTO(pet));
        petService.save(petMapper.toDTO(pet2));



        Visit visit=new Visit(1L,LocalDate.of(2021,10,6),"kontrol",pet);
        visitService.save(visitMapper.toDTO(visit));

        Speciality speciality=new Speciality(1L,"operasyon yapabilir");
        specialityService.save(specialityMapper.toDTO(speciality));

        Vet vet1=new Vet(1L,"Hasan","Tarık",null);
        vet1.addSpeciality(speciality);
        specialityService.save(specialityMapper.toDTO(speciality));
        vetService.save(vetMapper.toDTO(vet1));










    }
}
