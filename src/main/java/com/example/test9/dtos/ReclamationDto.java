package com.example.test9.dtos;

import java.util.Date;


import com.example.test9.enums.Etat;
import com.example.test9.model.Contribuable;
import lombok.Data;
@Data
public class ReclamationDto {
    private long idReclamation;
    private String titre;
    private String contenu;
    private Etat etat;
    private Date dateReclamation;
    private String solution;
    private long idDeclaration;
    private Contribuable contribuable;
}