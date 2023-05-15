package com.example_project.project.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example_project.project.entity.ApplicationEntity;

public interface ApplicationRepository
                extends CrudRepository<ApplicationEntity, Long>, JpaSpecificationExecutor<ApplicationEntity> {

}

// CREATEBUILDER, temas de la proxima semanana