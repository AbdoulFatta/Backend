package com.example.test9.dtos;

import java.util.Date;



import com.example.test9.model.Activite;
import com.example.test9.model.FormeJuridique;
import com.example.test9.model.Pays;
import lombok.Data;
@Data
public class ContribuableDtos {

    private Long idContribuable;
    private int matriculeFiscale;
    private String nomCommercial;
    private String email;
    private String adress;
    private Date dateDeMatriculation;
    private String raisonSocial;
    private FormeJuridique formeJuridique;
    private Pays pays;
    private Activite activite;
    private String Directeur;
}