package com.example.test9.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.test9.dtos.ReclamationDto;
import com.example.test9.dtos.ReclamtionResponse;
import com.example.test9.dtos.UpdateSolutionRecDto;
import com.example.test9.enums.Etat;
import com.example.test9.model.Contribuable;
import com.example.test9.model.Declaration;
import com.example.test9.model.Reclamation;
import com.example.test9.repo.ContribuableRepository;
import com.example.test9.repo.DeclarationRepository;
import com.example.test9.repo.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ReclamationServiceImpl implements ReclamationService{


    @Autowired
    private ReclamationRepository reclamationrepo;
    @Autowired
    private DeclarationRepository declarationrepo;
    @Autowired
    private ContribuableRepository contribuableRepository;

    @Override
    public Reclamation saveReclamation(ReclamationDto c) {

        Contribuable existingContribuable = this.contribuableRepository.findById(c.getContribuable().getIdcontribuable())
                .orElseThrow(() -> new IllegalArgumentException("Contribuable not found"));

        // Create a new Reclamation object and set its attributes
        if(c.getIdDeclaration()!=0l) {
            Optional<Declaration> declaration=declarationrepo.findById(c.getIdDeclaration());

            if(declaration.isPresent()) {
                Reclamation newReclamation = new Reclamation();
                newReclamation.setContenu(c.getContenu());
                newReclamation.setEtat(Etat.EN_ATTENTE);
                newReclamation.setSolution(null);
                newReclamation.setDate_reclamation(new Date());
                newReclamation.setTitre(c.getTitre());
                newReclamation.setDeclaration(declaration.get());
                newReclamation.setContribuable(existingContribuable);
                this.reclamationrepo.save(newReclamation);
                return newReclamation;
            }else return null;
        }else {
            Reclamation newReclamation = new Reclamation();
            newReclamation.setContenu(c.getContenu());
            newReclamation.setEtat(Etat.EN_ATTENTE);
            newReclamation.setSolution(null);
            newReclamation.setDate_reclamation(new Date());
            newReclamation.setTitre(c.getTitre());
            newReclamation.setContribuable(existingContribuable);
            this.reclamationrepo.save(newReclamation);
            return newReclamation;
        }


    }


    @Override
    public List<ReclamtionResponse> getAllReclamation() {
        return reclamationrepo.findAll().stream().map(Reclamation::getId_reclamation).collect(Collectors.toList());

    }


    @Override
    public Reclamation updateSolution(UpdateSolutionRecDto rd) {
        // TODO Auto-generated method stub
        Optional<Reclamation> reclamation=reclamationrepo.findById(rd.getIdReclamation());
        if(reclamation.isPresent()) {
            if(rd.getEtat()==Etat.REFUSEE) {
                reclamation.get().setSolution("Votre réclamation a été refusée en raison de la non-conformité aux termes et conditions.");
                reclamation.get().setEtat(Etat.REFUSEE);
                reclamationrepo.save(reclamation.get());
                return reclamation.get();}
            else{
                reclamation.get().setSolution(rd.getSolution());
                reclamation.get().setEtat(Etat.EN_COURS);
                reclamationrepo.save(reclamation.get());
                return reclamation.get();
            }
        }else {
            return null;
        }
    }
    @Override
    public List<Reclamation> reclamationByContribuable(int matriculeFiscale){
        Optional<Contribuable> contribuable=contribuableRepository.findByMatriculeFiscale(matriculeFiscale);
        if(contribuable.isPresent()) {
            List<Reclamation> listeReclamations=reclamationrepo.findByContribuable(contribuable.get());
            return listeReclamations;
        }else return null;
    }


    @Override
    public boolean updateEtat(Long id) {
        Optional<Reclamation> reclamation=reclamationrepo.findById(id);
        if(reclamation.isPresent()) {

            reclamation.get().setEtat(Etat.RESOLUE);
            reclamationrepo.save(reclamation.get());
            return true;
        }else return false;
    }
    @Override
    public boolean refusEtat(Long id) {
        Optional<Reclamation> reclamation=reclamationrepo.findById(id);
        if(reclamation.isPresent()) {

            reclamation.get().setEtat(Etat.REFUSEE);
            reclamationrepo.save(reclamation.get());
            return true;
        }else return false;
    }
}