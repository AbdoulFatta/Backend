package com.example.test9.dtos;


import com.example.test9.enums.NatureRebrique;
import lombok.Data;

@Data
public class DetailDeclarationDto {


    private Long iddetailDeclaration;

    private String valeur;
    private Long iddeclaration;
    private NatureRebrique naturerebrique;
}