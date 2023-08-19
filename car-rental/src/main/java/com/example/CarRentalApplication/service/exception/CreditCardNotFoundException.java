package com.example.CarRentalApplication.service.exception;

public class CreditCardNotFoundException extends RuntimeException {
    public CreditCardNotFoundException(String msg) {
        super(msg);
    }
}
