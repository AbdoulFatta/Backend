package com.example.test9.service;


import com.example.test9.dtos.ContribuableDtos;

import java.util.List;

public interface ContribuableService {

    ContribuableDtos saveContribuable(ContribuableDtos cd);
    ContribuableDtos findContribuable(int matriculeFiscale);
    List<ContribuableDtos> lesContribuables();
    ContribuableDtos findContribuableByIdCompte(long IdCompte);

}
