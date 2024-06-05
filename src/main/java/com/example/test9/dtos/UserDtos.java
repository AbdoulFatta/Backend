package com.example.test9.dtos;


import com.example.test9.enums.Identifiant;
import com.example.test9.enums.UserRole;
import com.example.test9.model.Contribuable;
import lombok.Data;

@Data
public class UserDtos {
    private Long idInscription;

    private String email;

    private String Poste;

    private String password;

    private String VerificationCode;

    private Boolean enabled;

    private boolean NonLocked;
    private java.util.Date dateInscri;

    private UserRole userRole;
    private Identifiant typeIdentifiant;
    private String valueIdentifiant;
    private String nom;
    private String prenom;
    private Contribuable contribuable;
}