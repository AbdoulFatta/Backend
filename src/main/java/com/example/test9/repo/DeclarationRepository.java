package com.example.test9.repo;


import com.example.test9.model.Declaration;
import com.example.test9.model.ObligationFiscale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeclarationRepository extends JpaRepository<Declaration,Long> {


    Optional<Declaration> findByMoiseffetAndAnneeeffetAndObligation(int moiseffet, int anneeeffet, ObligationFiscale obligation);
    List<Declaration> findByObligation_Contribuable_MatriculeFiscale(int matriculeFiscale);
}