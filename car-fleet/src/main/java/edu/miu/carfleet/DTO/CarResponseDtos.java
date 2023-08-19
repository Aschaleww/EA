package edu.miu.carfleet.DTO;

import java.util.List;

public class CarResponseDtos {
    private List<CarDto> cars;

    public CarResponseDtos() {
    }

    public CarResponseDtos(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarResponseDtos{" +
                "cars=" + cars +
                '}';
    }
}
