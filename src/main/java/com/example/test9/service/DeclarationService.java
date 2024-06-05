package com.example.test9.service;

import java.util.List;
import java.util.Map;


import com.example.test9.dtos.DetailDeclarationDto;
import com.example.test9.dtos.SaveDeclaration;
import com.example.test9.dtos.SaveMontant;
import com.example.test9.model.Declaration;
import com.example.test9.model.DetailImpot;

public interface DeclarationService {


    Map<DetailImpot, DetailDeclarationDto> saveDeclaration(SaveDeclaration dc);
    boolean updateMontantaCalculer(SaveMontant di);
    List<Declaration> getDeclarationsByMatriculeFiscale(int matriculeFiscale);
}