package com.example.CarRentalApplication.service.exception;

public class CarNotAvailableException extends RuntimeException {
    public CarNotAvailableException(String msg) {
        super(msg);
    }
}
