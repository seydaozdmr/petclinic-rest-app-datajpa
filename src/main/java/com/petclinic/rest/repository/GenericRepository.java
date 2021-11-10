package com.petclinic.rest.repository;

import com.petclinic.rest.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T,Long> {
}
