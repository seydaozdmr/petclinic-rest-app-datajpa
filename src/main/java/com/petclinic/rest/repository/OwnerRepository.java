package com.petclinic.rest.repository;

import com.petclinic.rest.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends GenericRepository<Owner> {
    @Override
    Optional<Owner> findById(Long aLong);

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
