package com.example.test9.model;

import com.example.test9.dtos.PeriodeDto;
import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "periodicite")
public class Periodicite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator9Name")
    @SequenceGenerator(name = "yourGenerator9Name", sequenceName = "periodicite_seq", allocationSize = 1)
    private long id_periodicite;

    private String periode;
    public PeriodeDto getperiodicite() {
        PeriodeDto periode1=new PeriodeDto();
        periode1.setIdPeriodicite(id_periodicite);
       // periode1.setPeriode(periode);
        return periode1;
    }
}
