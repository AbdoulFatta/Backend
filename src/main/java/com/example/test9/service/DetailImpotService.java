package com.example.test9.service;


import com.example.test9.dtos.DetailImpotDto;
import com.example.test9.model.DetailImpot;

import java.util.List;

public interface DetailImpotService {

    DetailImpotDto saveDetailImpot(DetailImpotDto di);
    List<DetailImpot> findbytypeImpot(String libelle);
}