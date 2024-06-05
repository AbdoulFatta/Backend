package com.example.test9.service;

import com.example.test9.dtos.PaysDtos;
import com.example.test9.model.Pays;
import com.example.test9.repo.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaysServiceImpl implements PaysService{

    @Autowired
    private PaysRepository paysRepo;

    @Override
    public PaysDtos savePays(PaysDtos pd) {
        Pays pays=new Pays();
        pays.setLibelle(pd.getLibelle());

        Pays paysCree=paysRepo.save(pays);
        PaysDtos paysCreeDtos=new PaysDtos();
        paysCreeDtos.setIdPays(paysCree.getId_pays());
        paysCreeDtos.setLibelle(paysCree.getLibelle());

        return paysCreeDtos;

    }

}