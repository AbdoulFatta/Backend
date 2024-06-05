package com.example.test9.service;


import com.example.test9.dtos.DetailDeclarationDto;
import com.example.test9.model.DetailDeclaration;

import java.util.List;

public interface DetailDeclarationService {

    boolean	updateDetail(DetailDeclarationDto dd);
    List<DetailDeclaration> getdetailBydeclarationId(long id);
}
