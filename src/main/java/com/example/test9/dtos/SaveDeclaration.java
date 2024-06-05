package com.example.test9.dtos;



import com.example.test9.model.TypeDeclaration;
import lombok.Data;

@Data
public class SaveDeclaration {



    private int  moisEffet;

    private int  anneeEffet;

    private Long idObligation;

    private TypeDeclaration type;
}
