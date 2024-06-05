package com.example.test9.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.test9.dtos.PeriodeDto;
import com.example.test9.model.Periodicite;
import com.example.test9.repo.PeriodiciteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeriodiciteServiceImpl implements PeriodiciteService{

    @Autowired
    private PeriodiciteRepository perioderepo;


    @Override
    public List<PeriodeDto> findAllPeriode() {
        return perioderepo.findAll().stream().map(Periodicite::getId_periodicite).collect(Collectors.toList());
    }

}
