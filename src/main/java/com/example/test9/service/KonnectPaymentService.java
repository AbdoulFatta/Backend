package com.example.test9.service;


import com.example.test9.dtos.PaymentRequest;
import com.example.test9.dtos.PaymentResponse;
import com.example.test9.dtos.PaymentStatus;

public interface KonnectPaymentService {

    public PaymentResponse initiatePayment(PaymentRequest paymentRequest);
    public PaymentStatus getPaymentStatus(String paymentId);


}