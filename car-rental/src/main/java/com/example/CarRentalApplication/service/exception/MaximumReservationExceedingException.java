package com.example.CarRentalApplication.service.exception;

public class MaximumReservationExceedingException extends RuntimeException {
    public MaximumReservationExceedingException(String msg) {
        super(msg);
    }
}
