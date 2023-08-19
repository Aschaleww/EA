package com.example.CarRentalApplication.service.exception;

public class RentalNotFoundException extends RuntimeException {
    public RentalNotFoundException(String msg) {
        super(msg);
    }
}
