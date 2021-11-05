package com.petclinic.rest.repository;

import com.petclinic.rest.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends GenericRepository<Owner> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
