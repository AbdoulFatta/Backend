package com.example.test9.dtos;



import com.example.test9.enums.Etat;
import lombok.Data;

@Data
public class UpdateSolutionRecDto {
    private long idReclamation;
    private String solution;
    private Etat etat;
}
