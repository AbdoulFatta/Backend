package com.example.test9.dtos;

import java.util.Date;


import com.example.test9.enums.Etat;
import com.example.test9.model.Contribuable;
import com.example.test9.model.Declaration;
import lombok.Data;
@Data
public class ReclamtionResponse {

    private long idReclamation;
    private String titre;
    private String contenu;
    private Etat etat;
    private Date dateReclamation;
    private String solution;
    private Declaration declaration;
    private Contribuable contribuable;
}
