package com.example.test9.repo;

import com.example.test9.model.Contribuable;
import com.example.test9.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findByContribuable(Contribuable contribuable);
}