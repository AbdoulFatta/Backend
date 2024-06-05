package com.example.test9.repo;

import com.example.test9.model.TypeImpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeImpotRepository extends JpaRepository<TypeImpot,Long> {


    Optional<TypeImpot> findByLibelle(String libelle);
}