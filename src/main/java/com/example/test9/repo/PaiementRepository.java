package com.example.test9.repo;

import com.example.test9.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {



    List<Paiement> findByNumeroTransaction(String numeroTransaction);

}
