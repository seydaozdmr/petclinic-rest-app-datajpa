package com.petclinic.rest.repository;

import com.petclinic.rest.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends GenericRepository<Pet> {
}
