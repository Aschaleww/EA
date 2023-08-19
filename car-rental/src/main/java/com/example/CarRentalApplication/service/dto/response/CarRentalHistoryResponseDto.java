package com.example.CarRentalApplication.service.dto.response;

import com.example.CarRentalApplication.integration.rest.CarResponseDto;

import java.util.List;

public class CarRentalHistoryResponseDto {
    private CarResponseDto car;
    private List<RentalEntryResponseDto> rentals;

    public CarRentalHistoryResponseDto() {
    }

    public CarRentalHistoryResponseDto(CarResponseDto car, List<RentalEntryResponseDto> rentals) {
        this.car = car;
        this.rentals = rentals;
    }

    public CarResponseDto getCar() {
        return car;
    }

    public void setCar(CarResponseDto car) {
        this.car = car;
    }

    public List<RentalEntryResponseDto> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalEntryResponseDto> rentals) {
        this.rentals = rentals;
    }
}
