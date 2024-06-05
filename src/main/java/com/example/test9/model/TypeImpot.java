package com.example.test9.model;

import com.example.test9.dtos.PeriodeDto;
import com.example.test9.dtos.TypeImpotDto;
import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "type_impot")
public class TypeImpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator8Name")
    @SequenceGenerator(name = "yourGenerator8Name", sequenceName = "typeImpot_seq", allocationSize = 1)
    private long id_typeImpot;

    private String libelle;

    private String formule;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "periodicite_id")
    private Periodicite periodicite;

    public TypeImpotDto getImpot() {
        TypeImpotDto impot=new TypeImpotDto();
        impot.setLibelle(libelle);
        PeriodeDto pd=new PeriodeDto();
        pd.setIdPeriodicite(periodicite.getId_periodicite());
        //pd.setPeriode(periodicite.getPeriode());
        impot.setPeriodicite(pd);
        return impot;
    }
}
