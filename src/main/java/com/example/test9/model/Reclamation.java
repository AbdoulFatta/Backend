package com.example.test9.model;

import com.example.test9.dtos.ReclamtionResponse;
import com.example.test9.enums.Etat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Data
@Entity
@Table(name = "reclamation")
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator15Name")
    @SequenceGenerator(name = "yourGenerator15Name", sequenceName = "Reclamation_seq", allocationSize = 1)
    private long id_reclamation;


    private String titre;

    private String contenu;

    private Etat etat;

    private Date date_reclamation;

    private String solution;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "declaration_id", nullable = true)
    private Declaration declaration;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "contribuable_id", nullable = false)
    private Contribuable contribuable;

    public ReclamtionResponse getreclamation()
    {
        ReclamtionResponse reclamation=new ReclamtionResponse();
        reclamation.setContenu(contenu);
        reclamation.setDateReclamation(date_reclamation);
        reclamation.setEtat(etat);
        reclamation.setDeclaration(declaration);
        reclamation.setSolution(solution);
        reclamation.setTitre(titre);
        reclamation.setIdReclamation(id_reclamation);
        reclamation.setContribuable(contribuable);
        return reclamation;
    }


}
