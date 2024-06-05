package com.example.test9.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.test9.dtos.PaiementDto;
import com.example.test9.model.Declaration;
import com.example.test9.model.Paiement;
import com.example.test9.repo.DeclarationRepository;
import com.example.test9.repo.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private DeclarationRepository declarationrepo;
    @Autowired
    private PaiementRepository paiementrepo;

    @Override
    public boolean createPaiement(PaiementDto paiementDto) {
        Optional<Declaration> optionalDeclaration = declarationrepo.findById(paiementDto.getIddeclaration());

        if (optionalDeclaration.isPresent()) {
            List<Paiement> list=paiementrepo.findByNumeroTransaction(paiementDto.getNumeroTransaction());
            if(list.isEmpty()) {
                Declaration declaration = optionalDeclaration.get();

                Paiement paiement = new Paiement();
                paiement.setDeclaration(declaration);
                paiement.setNumeroTransaction(Integer.valueOf(paiementDto.getNumeroTransaction()));
                paiement.setDate_paiement(new Date());

                Paiement savedPaiement = paiementrepo.save(paiement);

                return savedPaiement != null;
            }else
                return false;
        }else {
            return false;
        }
    }


}