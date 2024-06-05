package com.example.test9.model;

import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity
@Table(name = "detailimpot")
public class DetailImpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator17Name")
    @SequenceGenerator(name = "yourGenerator17Name", sequenceName = "detailImpot_seq", allocationSize = 1)
    private long id_detailimpot;


    private String libelle;

    private String type_detail;

    private boolean calculable;

    private String formule;

    private int ordre;

    private boolean  obligatoire;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_typeImpot")
    private TypeImpot typeImpot;




}
