package com.example.test9.model;

import com.example.test9.dtos.ContribuableDtos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "contribuables")
public class Contribuable {
    @Id
    private String numerofiscal;
    private String password;

    private Long idcontribuable;
    private int matriculefiscale;
    private String nomcommercial;
    private String email;
    private String adress;
    private Date datedematriculation;
    private String raisonSocial;
    private String directeur;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "formejuridique_id")
    private FormeJuridique formeJuridique;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "activite_id")
    private Activite activite;

    @Override
    public String toString() {
        return "Contribuable{" +
                "idContribuable=" + idcontribuable +
                ", matriculeFiscale=" + matriculefiscale +
                ", nomCommercial='" + nomcommercial + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", dateDeMatriculation=" + datedematriculation +
                ", raisonSocial='" + raisonSocial + '\'' +
                ", directeur='" + directeur + '\'' +
                ", formeJuridique=" + (formeJuridique != null ? formeJuridique.getId_formeJuridique() : null) + // Avoid cyclic reference
                ", pays=" + (pays != null ? pays.getId_pays() : null) + // Avoid cyclic reference
                ", activite=" + (activite != null ? activite.getIdactivite() : null) + // Avoid cyclic reference
                '}';
    }
    public ContribuableDtos getContribuable() {
        ContribuableDtos contribuable=new ContribuableDtos();
        contribuable.setActivite(activite);
        contribuable.setAdress(adress);
        contribuable.setDateDeMatriculation(datedematriculation);
        contribuable.setDirecteur(directeur);
        contribuable.setFormeJuridique(formeJuridique);
        contribuable.setMatriculeFiscale(matriculefiscale);
        contribuable.setEmail(email);
        contribuable.setRaisonSocial(raisonSocial);
        contribuable.setPays(pays);
        contribuable.setNomCommercial(nomcommercial);
        return contribuable;

    }


}
