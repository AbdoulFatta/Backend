package com.example.test9.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class ObligationDto {



    private Date dateDebut;
    private Date dateFin;
    private TypeImpotDto impot;
}