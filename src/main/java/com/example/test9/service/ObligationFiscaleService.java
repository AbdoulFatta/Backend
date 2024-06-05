package com.example.test9.service;


import com.example.test9.dtos.ObligationresponseDto;
import com.example.test9.model.Contribuable;
import com.example.test9.model.Declaration;

import java.util.List;

public interface ObligationFiscaleService {
    Declaration getNumerodeclaration(Contribuable cd, Long iddecalaration);

    List<ObligationresponseDto> getlesObligationsdeContribuable(Contribuable cd);
}