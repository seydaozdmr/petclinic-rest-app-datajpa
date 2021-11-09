package com.petclinic.rest.repository;

import com.petclinic.rest.model.Speciality;
import com.petclinic.rest.model.Vet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends GenericRepository<Speciality> {
    List<Speciality> findAllByDescription(String description);
}
