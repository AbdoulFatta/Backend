package com.example.test9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity

@Table(name = "pays")
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator4Name")
    @SequenceGenerator(name = "yourGenerator4Name", sequenceName = "pays_seq", allocationSize = 1)
    private long id_pays;
    private String libelle;

    @OneToMany(mappedBy = "pays")
    @JsonIgnore
    private Set<Contribuable> contribuables;
}
