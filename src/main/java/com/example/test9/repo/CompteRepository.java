package com.example.test9.repo;


import com.example.test9.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte,Long> {
    Optional<Compte> findByEmail(String email);



}
