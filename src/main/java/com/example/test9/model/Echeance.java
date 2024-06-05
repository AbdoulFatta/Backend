package com.example.test9.model;

import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "echeance")
public class Echeance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator10Name")
    @SequenceGenerator(name = "yourGenerator10Name", sequenceName = "echeance_seq", allocationSize = 1)
    private long id_echeance;

    private int jour;
    private int mois;
    private int numeroecheance;
    private int annee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_typeImpot")
    private TypeImpot typeImpot;
}
