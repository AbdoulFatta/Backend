package com.example.test9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "forme_juridique")
public class FormeJuridique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator3Name")
    @SequenceGenerator(name = "yourGenerator3Name", sequenceName = "forme_juridique_seq", allocationSize = 1)
    private Long id_formeJuridique;

    private String libelle;

    @OneToMany(mappedBy = "formeJuridique")
    @JsonIgnore
    private List<Contribuable> contribuables;

}
