package com.example.test9.repo;

import com.example.test9.model.Contribuable;
import com.example.test9.model.ObligationFiscale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObligationFiscaleRepository extends JpaRepository<ObligationFiscale,Long> {

    List<ObligationFiscale> findByContribuable(Contribuable contribuable);
}
