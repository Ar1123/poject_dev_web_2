package com.example_project.project.repository;

import org.springframework.data.jpa.domain.Specification;

import com.example_project.project.entity.ApplicationEntity;
import com.example_project.project.entity.ServerEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class CustomRepository {

    public Specification<ServerEntity> getServers() {
        return new Specification<ServerEntity>() {
            @Override
            public Predicate toPredicate(Root<ServerEntity> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {

                Subquery<Long> subquery = query.subquery(Long.class);
                Root<ApplicationEntity> aplicacionRoot = subquery.from(ApplicationEntity.class);
                subquery.select(criteriaBuilder.count(aplicacionRoot.get("id")))
                        .where(criteriaBuilder.equal(aplicacionRoot.get("server"), root));

                return criteriaBuilder.greaterThan(subquery, 1L);
            }
        };
    }

}
