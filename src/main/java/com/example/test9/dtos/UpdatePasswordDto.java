package com.example.test9.dtos;


import lombok.Data;

@Data
public class UpdatePasswordDto {
    private Long id;
    private String passwordPrec;
    private String nvPassword;
}