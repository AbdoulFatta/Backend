package com.example.test9.service;

import com.example.test9.dtos.ActiviteDtos;
import com.example.test9.model.Activite;
import com.example.test9.repo.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ActiviteServiceImpl implements ActiviteService{

    @Autowired
    private ActiviteRepository Activiterepo;

    @Override
    public ActiviteDtos saveActivite(ActiviteDtos ad) {
        Activite activite=new Activite();
        activite.setLibelle(ad.getLibelle());

        Activite activiteCree=Activiterepo.save(activite);
        ActiviteDtos activiteCreeDtos=new ActiviteDtos();
        activiteCreeDtos.setIdActivite(activiteCree.getIdactivite());
        activiteCreeDtos.setLibelle(activiteCree.getLibelle());

        return activiteCreeDtos;
    }

}
