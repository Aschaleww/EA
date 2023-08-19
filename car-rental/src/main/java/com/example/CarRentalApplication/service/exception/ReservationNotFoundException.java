package com.example.CarRentalApplication.service.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String msg) {
        super(msg);
    }
}
