package com.example.CarRentalApplication.service.dto.request;

import java.time.LocalDate;

public class RentalRequestDto {
    private String licensePlate;
    private String customerNumber;

    private LocalDate returnedDate;

    private String reservationId;

    public RentalRequestDto() {
    }

    public RentalRequestDto(String licensePlate, String customerNumber, LocalDate returnedDate, String reservationId) {
        this.licensePlate = licensePlate;
        this.customerNumber = customerNumber;
        this.returnedDate = returnedDate;
        this.reservationId = reservationId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
