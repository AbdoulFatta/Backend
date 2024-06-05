package com.example.test9.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.test9.dtos.ImpotDto;
import com.example.test9.dtos.PeriodeDto;
import com.example.test9.dtos.TypeImpotDto;
import com.example.test9.enums.Periode;
import com.example.test9.model.Echeance;
import com.example.test9.model.Periodicite;
import com.example.test9.model.TypeImpot;
import com.example.test9.repo.EcheanceRepository;
import com.example.test9.repo.PeriodiciteRepository;
import com.example.test9.repo.TypeImpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TypeImpotServiceImpl implements TypeImpotService{


    @Autowired
    private EcheanceRepository echeanceRepository;
    @Autowired
    private TypeImpotRepository typeImpotRepository;
    @Autowired
    private PeriodiciteRepository periodiciteRepository;
    @Autowired
    private TypeImpotRepository impotrepo;

    @Override
    public TypeImpotDto saveImpot(TypeImpotDto td) {
        TypeImpot impot=new TypeImpot();
        impot.setLibelle(td.getLibelle());
        Periodicite periodicite = periodiciteRepository.findById(td.getPeriodicite().getIdPeriodicite())
                .orElseThrow(() -> new IllegalArgumentException("Invalid periodicite"));

        impot.setPeriodicite(periodicite);
        Periodicite nb=new Periodicite();
        nb.setId_periodicite(td.getPeriodicite().getIdPeriodicite());
        nb.setPeriode(String.valueOf(td.getPeriodicite().getPeriode()));
        impot.setPeriodicite(nb);
        TypeImpot     impot1=typeImpotRepository.save(impot);
        if(impot.getPeriodicite().getPeriode()== Periode.MENSUELLE) {
            for (int mois = 1; mois <= 12; mois++) {
                Echeance echeance = new Echeance();
                echeance.setJour(15); // Jour de l'échéance (exemple : le 15 de chaque mois)
                echeance.setMois(mois+1); // Mois de l'échéance (1 pour janvier, 2 pour février, etc.)
                echeance.setNumeroecheance(mois); // Numéro de l'échéance (1 à 12 pour chaque mois)


                int annee = 0;
                if (mois == 12) {
                    echeance.setMois(1);
                    annee = 1;
                }

                echeance.setAnnee(annee);

                echeance.setTypeImpot(impot);


                echeanceRepository.save(echeance); // Assurez-vous d'injecter echeanceRepository dans votre classe
            }

        }else if (impot.getPeriodicite().getPeriode() == Periode.TRIMESTRE) {
            for (int trimestre = 1; trimestre <= 4; trimestre++) {
                Echeance echeance = new Echeance();
                echeance.setJour(15); // Jour de l'échéance (exemple : le 15 de chaque mois)
                echeance.setMois(trimestre+3); // Mois de l'échéance (1 pour janvier, 2 pour février, etc.)
                echeance.setNumeroecheance(trimestre);
                int annee = 0;
                if (trimestre == 4) {
                    echeance.setMois(1);
                    annee = 1;
                }
                echeance.setAnnee(annee);

                echeance.setTypeImpot(impot);


                echeanceRepository.save(echeance);
            }
        } else if (impot.getPeriodicite().getPeriode() == Periode.SEMESTRE) {
            for (int semestre = 1; semestre <= 2; semestre++) {
                Echeance echeance = new Echeance();
                echeance.setJour(15);
                echeance.setMois(7);
                echeance.setNumeroecheance(semestre);
                int annee = 0;
                if (semestre == 2) {
                    echeance.setMois(1);
                    annee = 1;
                }
                echeance.setAnnee(annee);

                echeance.setTypeImpot(impot);


                echeanceRepository.save(echeance);
            }
        } else if (impot.getPeriodicite().getPeriode() == Periode.ANNUELLE) {
            Echeance echeance = new Echeance();
            echeance.setJour(15);
            echeance.setMois(1);
            echeance.setNumeroecheance(1);


            echeance.setAnnee(1);

            echeance.setTypeImpot(impot);


            echeanceRepository.save(echeance);
        }

        TypeImpotDto savedImpot=new TypeImpotDto();

        savedImpot.setLibelle(impot1.getLibelle());
        PeriodeDto pd=new PeriodeDto();
        pd.setIdPeriodicite(impot1.getPeriodicite().getId_periodicite());
        pd.setPeriode(Periode.valueOf(impot1.getPeriodicite().getPeriode()));
        savedImpot.setPeriodicite(pd);
        return savedImpot;
    }


   /* @Override
    public List<TypeImpotDto> getAllImpots() {
        // TODO Auto-generated method stub
        return impotrepo.findAll().stream().map(TypeImpot::getId_typeImpot).collect(Collectors.toList());
    }

    */


    @Override
    public TypeImpotDto findTypeImpotbyLibelle(String libelle) {
        Optional<TypeImpot> typetrouve=impotrepo.findByLibelle(libelle);
        if(typetrouve.get()!=null) {
            TypeImpotDto impot=new TypeImpotDto();
            impot.setLibelle(typetrouve.get().getLibelle());

            PeriodeDto periode=new PeriodeDto();
            periode.setIdPeriodicite(typetrouve.get().getPeriodicite().getId_periodicite());
            periode.setPeriode(Periode.valueOf(typetrouve.get().getPeriodicite().getPeriode()));
            impot.setPeriodicite(periode);
            return impot;
        }else return null;
    }


    @Override
    public boolean updateImpot(ImpotDto id) {
        Optional<TypeImpot> typetrouve=impotrepo.findByLibelle(id.getLibelle());
        if(typetrouve.get()!=null) {
            typetrouve.get().setFormule(id.getFormule());
            impotrepo.save(typetrouve.get());
            return true;
        }else return false;

    }

}