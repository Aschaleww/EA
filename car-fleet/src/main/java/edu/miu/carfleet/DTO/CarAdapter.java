package edu.miu.carfleet.DTO;

import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Domain.CarStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CarAdapter {

    public static CarDto ConverToDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setType(car.getType());
        carDto.setBrand(car.getBrand());
        carDto.setPrice(car.getPrice());
        carDto.setAvailability(car.getStatus() == CarStatus.AVAILABLE);
        return carDto;
    }

    public static Car convertToCar(CarDto carDto) {
        Car car = new Car();
        car.setLicensePlate(carDto.getLicensePlate());
        car.setType(carDto.getType());
        car.setBrand(carDto.getBrand());
        car.setPrice(carDto.getPrice());
        if(carDto.getAvailability()) {
            car.setStatus(CarStatus.AVAILABLE);
        } else {
            car.setStatus(CarStatus.RESERVED);
        }
        return car;
    }

    public static CarResponseDtos convertToDtos(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(ConverToDto(car));
        }
        return new CarResponseDtos(carDtos);
    }
}
