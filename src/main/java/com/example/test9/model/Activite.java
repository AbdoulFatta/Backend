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
@Table(name = "activite")
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator1Name")
    @SequenceGenerator(name = "yourGenerator1Name", sequenceName = "activite_seq", allocationSize = 1)
    private Long idactivite;

    private String libelle;
    @OneToMany(mappedBy = "activite")
    @JsonIgnore
    private List<Contribuable> contribuables;


}
