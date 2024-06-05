package com.example.test9.repo;

import com.example.test9.model.Contribuable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ContribuableRepository extends JpaRepository<Contribuable, Long> {
    Optional<Contribuable> findByMatriculeFiscale(int matriculeFiscale);
}
