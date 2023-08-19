package com.example.CarRentalApplication.integration.jms;

public class CarDataJSMEventDeleted {
    private String licensePlate;

    private Boolean availability;

    public CarDataJSMEventDeleted() {
    }

    public CarDataJSMEventDeleted(String licensePlate, Boolean availability) {
        this.licensePlate = licensePlate;
        this.availability = availability;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
