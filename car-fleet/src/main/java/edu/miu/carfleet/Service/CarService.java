package edu.miu.carfleet.Service;

import edu.miu.carfleet.DTO.CarAdapter;
import edu.miu.carfleet.DTO.CarDto;
import edu.miu.carfleet.DTO.CarResponseDtos;
import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Domain.CarStatus;
import edu.miu.carfleet.Exception.NotFoundException;
import edu.miu.carfleet.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public CarDto CreateCar(CarDto carDto) {
        Car car = CarAdapter.convertToCar(carDto);
        Car savedCar = carRepository.save(car);
        return CarAdapter.ConverToDto(savedCar);
    }

    public CarDto findCarByPlate(String licensePlate) {
        Car car = carRepository.findByLicensePlate(licensePlate);
        if (car == null) {
            throw new NotFoundException("Car Not Found with plate:" + licensePlate);
        }
        return CarAdapter.ConverToDto(car);
    }

    public CarResponseDtos findAll() {
        List<Car> cars = carRepository.findAll();
        return CarAdapter.convertToDtos(cars);
    }

    public void deleteCar(String licensePlate) {
        Car carDto = carRepository.findByLicensePlate(licensePlate);
        if (carDto == null) {
            throw new NotFoundException("The Car is not found with this plate");
        }
        carRepository.delete(carDto);
    }

    public CarDto updateCar(String licensePlate, CarDto carUpdate) {
        Car existingCar = carRepository.findByLicensePlate(licensePlate);
        if (existingCar == null) {
            throw new NotFoundException("The Car is not found with this plate");
        }
        existingCar.setType(carUpdate.getType());
        existingCar.setBrand(carUpdate.getBrand());
        existingCar.setPrice(carUpdate.getPrice());

        Car savedCar = carRepository.save(existingCar);
        return CarAdapter.ConverToDto(savedCar);
    }

    //counting the amount of car based on brand and type
    public long countCarsByBrandsAndType(String brand, String type) {
        return carRepository.countByBrandAndCarType(brand, type);
    }

    public CarResponseDtos findAvaliableCar() {
        List<Car> availableCars = carRepository.findByStatus(CarStatus.AVAILABLE);
        return CarAdapter.convertToDtos(availableCars);
    }

    public CarResponseDtos findReservedCars() {
        List<Car> reservedCar = carRepository.findByStatus(CarStatus.RESERVED);
        return CarAdapter.convertToDtos(reservedCar);
    }
     public List<CarDto> getMinimum(long minimum){

        List<CarDto> min = new ArrayList<>();
        List<Car> allCars = carRepository.findAll();

        if(allCars.size() < minimum){
            for(Car car: allCars)
            min.add(CarAdapter.ConverToDto(car));
        }
         return min;
     }


     }

