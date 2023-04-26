package com.example_project.project.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example_project.project.entity.ServerEntity;

public interface ServerRepository extends CrudRepository<ServerEntity, Long>, JpaSpecificationExecutor<ServerEntity> {

}
