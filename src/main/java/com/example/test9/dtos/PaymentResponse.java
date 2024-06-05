package com.example.test9.dtos;

import lombok.Data;

@Data
public class PaymentResponse {
    private String payUrl;
    private String paymentRef;
}
