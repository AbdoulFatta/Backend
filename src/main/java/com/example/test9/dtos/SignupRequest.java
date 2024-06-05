package com.example.test9.dtos;


import com.example.test9.enums.Identifiant;
import com.example.test9.model.Contribuable;
import lombok.Data;

@Data
public class SignupRequest {

    private String email;
    private String name;
    private String poste;
    private String password;
    private String nom;
    private String prenom;
    private Contribuable contribuable;
    private Identifiant typeIdentifiant;
    private String valueIdentifiant;

}