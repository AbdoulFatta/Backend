package com.example.test9.service;

import com.example.test9.dtos.FormeJuridiqueDtos;
import com.example.test9.model.FormeJuridique;
import com.example.test9.repo.FormeJuridiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FormeJuridiqueServiceImpl implements FormeJuridiqueService{

    @Autowired
    private FormeJuridiqueRepository formeJuridiqueRepo;

    @Override
    public FormeJuridiqueDtos saveFormeJuridique(FormeJuridiqueDtos fd) {

        FormeJuridique formejuridique=new FormeJuridique();
        formejuridique.setLibelle(fd.getLibelle());

        FormeJuridique formejuridiqueCree=formeJuridiqueRepo.save(formejuridique);
        FormeJuridiqueDtos formejuridiqueCreeDtos=new FormeJuridiqueDtos();
        formejuridiqueCreeDtos.setIdFormeJuridique(formejuridiqueCree.getId_formeJuridique());

        formejuridiqueCreeDtos.setLibelle(formejuridiqueCree.getLibelle());
        return formejuridiqueCreeDtos;




    }

}