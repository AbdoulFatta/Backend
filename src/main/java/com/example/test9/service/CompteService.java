package com.example.test9.service;


import com.example.test9.dtos.CompteById;
import com.example.test9.dtos.CompteDto;
import com.example.test9.dtos.MotDePassdto;

import java.util.List;

public interface CompteService {
    boolean saveCompte(CompteDto cd);
    List<CompteDto> getAllCompte();
    boolean blocageCompte(CompteDto cd);
    boolean AcceptCompte(CompteDto cd);
    boolean blocageCompteParEmail(String email);
    void updateFailedAttempt(String email);
    void resetFailedAttempt(String email);
    CompteById getCompteByid(Long id);
    boolean updatepassword(MotDePassdto md);
    boolean verifyPassword(String rawPassword, String encodedPasswordFromDB);
}