package edu.miu.carfleet.Controller;

import edu.miu.carfleet.DTO.CarDto;
import edu.miu.carfleet.DTO.CarResponseDtos;
import edu.miu.carfleet.Exception.NotFoundException;
import edu.miu.carfleet.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/cars")
    public ResponseEntity<?> CreateCar(@RequestBody CarDto car) {
        CarDto createdCar = carService.CreateCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }
    @GetMapping("/cars/{licensePlate}")
    public ResponseEntity<?> findByCarLicense(@PathVariable String licensePlate) {
        CarDto carDto = carService.findCarByPlate(licensePlate);
        if (carDto == null) {
            return new ResponseEntity<>(new NotFoundException("Car with Plate is Not Found" + licensePlate), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carDto, HttpStatus.OK);
    }

    // /cars -> all cars
    // /cars?available=true -> available cars
    // /cars?reserved=true -> reserved cars
    @GetMapping("/cars")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String status) {
        CarResponseDtos carDtos = new CarResponseDtos();
        if(Objects.equals(status, "available")) {
            carDtos = carService.findAvaliableCar();
        } else if (Objects.equals(status, "reserved")) {
            carDtos = carService.findReservedCars();
        } else {
            carDtos = carService.findAll();
        }

        return new ResponseEntity<>(carDtos, HttpStatus.OK);
    }
    @PutMapping("/cars/{licensePlate}")
    public CarDto updateCar(@PathVariable String licensePlate, @RequestBody CarDto updateCar) {
        return carService.updateCar(licensePlate, updateCar);
    }

    @DeleteMapping("/{licenseplate}")
    public ResponseEntity<?> deleteCar(@PathVariable String licenseplate) {
        // carService.deleteCar(licenseplate);
        CarDto carDto = carService.findCarByPlate(licenseplate);
        if (carDto == null) {
            return new ResponseEntity<>(new NotFoundException("This plate is not found"), HttpStatus.NOT_FOUND);
        }
        carService.deleteCar(licenseplate);
        return new ResponseEntity<CarDto>(HttpStatus.NO_CONTENT);
    }
//    @DeleteMapping("/{licensePlate}")
//    public ResponseEntity<?> deleteCar(@PathVariable String licenseplate) {
//        carService.deleteCar(licenseplate);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
    @GetMapping("/count/{brand}/{carType}")
    public ResponseEntity<Long> countCarsBrandAndType(@PathVariable String brand, @PathVariable String carType) {
        long count = carService.countCarsByBrandsAndType(brand, carType);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    @GetMapping("/cars/carTypes/shortage/{minimum}")
    public ResponseEntity<?> getCarsWithShortage(@PathVariable int minimum) {
        List<CarDto> carsWithShortage = carService.getMinimum(minimum);
        if (carsWithShortage.isEmpty()) {
            return new ResponseEntity<>(new NotFoundException("There is no carList"),HttpStatus.NOT_FOUND);
        } else {
            CarResponseDtos carResponseDtos = new CarResponseDtos();
            return ResponseEntity.ok(carsWithShortage);
        }
    }
}


