package com.example.test9.dtos;



import com.example.test9.enums.TypeDeclarationEnum;
import lombok.Data;

@Data
public class TypeDeclarationDto {



    private Long idTypeDeclaration;

    private TypeDeclarationEnum type;
}