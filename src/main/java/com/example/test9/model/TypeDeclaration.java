package com.example.test9.model;

import com.example.test9.dtos.TypeDeclarationDto;
import com.example.test9.enums.TypeDeclarationEnum;
import jakarta.persistence.*;
import lombok.*;

@Setter

@Getter

@AllArgsConstructor

@NoArgsConstructor

@ToString
@Entity
@Table(name = "type_declaration")
public class TypeDeclaration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "yourGenerator20Name")
    @SequenceGenerator(name = "yourGenerator20Name", sequenceName = "typedeclaration_seq", allocationSize = 1)
    private Long id_type_declaration;


    private TypeDeclarationEnum libelle;
    public TypeDeclarationDto getType() {
        TypeDeclarationDto type=new TypeDeclarationDto();
        type.setIdTypeDeclaration(id_type_declaration);
        type.setType(libelle);
        return type;
    }
}
