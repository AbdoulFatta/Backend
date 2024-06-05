package com.example.test9.service;



import com.example.test9.dtos.DetailDeclarationDto;
import com.example.test9.model.Declaration;
import com.example.test9.model.DetailDeclaration;
import com.example.test9.repo.DeclarationRepository;
import com.example.test9.repo.DetailDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DetailDeclarationServiceImpl implements DetailDeclarationService{


    @Autowired
    private DetailDeclarationRepository detailrepo;
    @Autowired
    private DeclarationRepository declarationrepo;


    @Override
    public boolean updateDetail(DetailDeclarationDto dd) {
        Optional<DetailDeclaration> detail=detailrepo.findById(dd.getIddetailDeclaration());
        if(detail.isPresent()) {
            detail.get().setValeur(dd.getValeur());
            detail.get().setNaturerebrique(String.valueOf(dd.getNaturerebrique()));
            detailrepo.save(detail.get());
            return true;
        }else return false;
    }


    @Override
    public List<DetailDeclaration> getdetailBydeclarationId(long id) {
        Optional<Declaration> declaration=declarationrepo.findById(id);
        List<DetailDeclaration> list=detailrepo.findByDeclaration(declaration.get());
        return list;

    }


}