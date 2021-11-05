package com.petclinic.rest.repository;

import com.petclinic.rest.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends GenericRepository<PetType> {
}
