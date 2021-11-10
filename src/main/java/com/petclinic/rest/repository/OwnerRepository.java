package com.petclinic.rest.repository;

import com.petclinic.rest.model.Owner;

import java.util.List;

public interface OwnerRepository extends GenericRepository<Owner> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
