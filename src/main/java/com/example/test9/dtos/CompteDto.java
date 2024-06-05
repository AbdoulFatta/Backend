package com.example.test9.dtos;



import com.example.test9.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompteDto {
    private long idCompte;
    private String email;
    private String password;
    private UserRole userRole;
    private UserDtos inscription;
}