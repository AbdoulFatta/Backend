package com.example.test9.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.test9.dtos.ObligationresponseDto;
import com.example.test9.dtos.PeriodeDto;
import com.example.test9.dtos.TypeImpotDto;
import com.example.test9.enums.Periode;
import com.example.test9.model.Contribuable;
import com.example.test9.model.Declaration;
import com.example.test9.model.ObligationFiscale;
import com.example.test9.repo.DeclarationRepository;
import com.example.test9.repo.ObligationFiscaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ObligationFiscaleServiceImpl implements ObligationFiscaleService{
    @Autowired
    private ObligationFiscaleRepository obligationFiscaleRepository;
    @Autowired
    private DeclarationRepository declarationRepo;
    @Override
    public Declaration getNumerodeclaration(Contribuable cd, Long iddecalaration) {
        List<ObligationFiscale> lesobligations = obligationFiscaleRepository.findByContribuable(cd);
        Optional<Declaration> declaration = declarationRepo.findById(iddecalaration);

        if (declaration.isPresent()) {
            for (ObligationFiscale obligation : lesobligations) {
                if (obligation.getId_obligation_fiscale() == declaration.get().getObligation().getId_obligation_fiscale()) {
                    return declaration.get();
                }
            }
        }

        return null;

    }
    @Override
    public List<ObligationresponseDto> getlesObligationsdeContribuable(Contribuable cd) {
        List<ObligationFiscale> lesobligations=obligationFiscaleRepository.findByContribuable(cd);
        List<ObligationresponseDto> lesObligationsDto = new ArrayList<>();

        for(ObligationFiscale obligation : lesobligations) {
            ObligationresponseDto obligationDto = new ObligationresponseDto();
            obligationDto.setDateDebut(obligation.getDatedebut());
            obligationDto.setDateFin(obligation.getDatefin());
            obligationDto.setIdObligation(obligation.getId_obligation_fiscale());


            TypeImpotDto impot=new TypeImpotDto();
            impot.setLibelle(obligation.getImpot().getLibelle());
            PeriodeDto periode=new PeriodeDto();
            periode.setIdPeriodicite(obligation.getImpot().getPeriodicite().getId_periodicite());
            periode.setPeriode(Periode.valueOf(obligation.getImpot().getPeriodicite().getPeriode()));
            impot.setPeriodicite(periode);
            obligationDto.setImpot(impot);

            lesObligationsDto.add(obligationDto);
        }

        return lesObligationsDto;
    }

}