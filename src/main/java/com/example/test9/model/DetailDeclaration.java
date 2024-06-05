package com.example.test9.model;

import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Data
@Entity
@Table(name = "detaildeclaration")
public class DetailDeclaration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator19Name")
    @SequenceGenerator(name = "yourGenerator19Name", sequenceName = "detailDeclaration_seq", allocationSize = 1)

    private Long id_detaildeclaration;

    private String valeur;
    private String naturerebrique;

    @ManyToOne
    @JoinColumn(name = "id_detailImpot")
    private DetailImpot detailImpot;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_declaration")
    private Declaration declaration;
}