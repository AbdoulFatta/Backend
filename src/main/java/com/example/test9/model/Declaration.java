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
@Table(name = "declarations")
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator11Name")
    @SequenceGenerator(name = "yourGenerator11Name", sequenceName = "decalaration_seq", allocationSize = 1)
    private String id_declaration;
    private String datedeclaration;
    private String moiseffet;
    private String anneeeffet;
    private Float montantaCalculer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "obligation_id")
    private ObligationFiscale obligation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeDeclaration_id")
    private TypeDeclaration type;


}

