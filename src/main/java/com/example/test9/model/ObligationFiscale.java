package com.example.test9.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "obligation_fiscale")
public class ObligationFiscale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator7Name")
    @SequenceGenerator(name = "yourGenerator7Name", sequenceName = "Obligation_seq", allocationSize = 1)
    private long id_obligation_fiscale;



    private Date datedebut;
    private Date datefin;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_contribuable")
    private Contribuable contribuable;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_typeImpot")
    private TypeImpot impot;

}
