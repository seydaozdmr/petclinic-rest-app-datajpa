package com.petclinic.rest.repository;

import com.petclinic.rest.model.Speciality;

import java.util.List;

public interface SpecialityRepository extends GenericRepository<Speciality> {
    List<Speciality> findAllByDescription(String description);
}
