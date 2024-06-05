package com.example.test9.service;

import com.example.test9.dtos.CompteDto;
import com.example.test9.dtos.UpdatePasswordDto;
import com.example.test9.dtos.UserDtos;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface AdminService {
    List<UserDtos> getAllInscription();
    CompteDto acceptInscri(UserDtos ud);
    //void sendVerificationEmail(UserDtos user) throws UnsupportedEncodingException, MessagingException;
    public CompteDto changePassword(UpdatePasswordDto up);
    public boolean verifyPassword(String rawPassword, String encodedPasswordFromDB);
}
