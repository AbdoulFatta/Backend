package com.example.test9.dtos;



import com.example.test9.enums.UserRole;
import lombok.Data;

@Data
public class AuthentificationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;

}