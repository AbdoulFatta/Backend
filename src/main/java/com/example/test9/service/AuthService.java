package com.example.test9.service;

import java.io.UnsupportedEncodingException;


import com.example.test9.dtos.PasswordDto;
import com.example.test9.dtos.ResetPassword;
import com.example.test9.dtos.SignupRequest;
import com.example.test9.dtos.UserDtos;


public interface AuthService {
    UserDtos createCustomer(SignupRequest signupRequest);
    //void sendVerificationEmail(UserDtos user) throws UnsupportedEncodingException, MessagingException;
    boolean verify(String verificationCode);
    UserDtos validePassword(PasswordDto pd);
    UserDtos convertUser(String code);
   // boolean sendUpdatePasswordEmail(String email) throws UnsupportedEncodingException, MessagingException;
    boolean resetPassword(ResetPassword rp);
}