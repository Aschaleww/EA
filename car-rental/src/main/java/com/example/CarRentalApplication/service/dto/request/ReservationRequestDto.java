package com.example.CarRentalApplication.service.dto.request;

import java.time.LocalDate;

public class ReservationRequestDto {
    private String licensePlate;
    private String customerNumber;
    private LocalDate pickupDate;
    private LocalDate returnedDate;

    public ReservationRequestDto() {
    }

    public ReservationRequestDto(String licensePlate, String customerNumber, LocalDate pickupDate, LocalDate returnedDate) {
        this.licensePlate = licensePlate;
        this.customerNumber = customerNumber;
        this.pickupDate = pickupDate;
        this.returnedDate = returnedDate;
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

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Override
    public String toString() {
        return "ReservationRequestDto{" +
                "licensePlate='" + licensePlate + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", pickupDate=" + pickupDate +
                ", returnedDate=" + returnedDate +
                '}';
    }
}
