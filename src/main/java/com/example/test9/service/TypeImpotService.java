package com.example.test9.service;


import com.example.test9.dtos.ImpotDto;
import com.example.test9.dtos.TypeImpotDto;

import java.util.List;

public interface TypeImpotService {
    TypeImpotDto saveImpot(TypeImpotDto td);
    List<TypeImpotDto> getAllImpots();
    TypeImpotDto findTypeImpotbyLibelle(String libelle);
    boolean updateImpot(ImpotDto id);

}