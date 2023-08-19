package com.example.CarRentalApplication.service.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String msg) {
        super(msg);
    }
}
