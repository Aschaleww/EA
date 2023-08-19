package edu.miu.carfleet.Integration;

import edu.miu.carfleet.Domain.CarStatus;

public class CarDataJSMEvent {
    private String licensePlate;

    private CarStatus availability;

    public CarDataJSMEvent() {
    }

    public CarDataJSMEvent(String licensePlate, CarStatus availability) {
        this.licensePlate = licensePlate;
        this.availability = availability;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public CarStatus getAvailability() {
        return availability;
    }

    public void setAvailability(CarStatus availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "CarDataJSMEvent2{" +
                "licensePlate='" + licensePlate + '\'' +
                ", availability=" + availability +
                '}';
    }
}
