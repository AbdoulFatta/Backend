package com.example.test9.dtos;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;

}