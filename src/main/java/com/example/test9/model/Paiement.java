package com.example.test9.model;

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
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator40Name")
    @SequenceGenerator(name = "yourGenerator40Name", sequenceName = "paiement_seq", allocationSize = 1)
    private Long id_paiment;
    private Integer numeroTransaction;
    private Date date_paiement;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_declaration")
    private Declaration declaration;
}
