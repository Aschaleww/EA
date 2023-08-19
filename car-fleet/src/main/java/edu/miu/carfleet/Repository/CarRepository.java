package edu.miu.carfleet.Repository;

import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Domain.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findByLicensePlate(String licensePlate);
    long countByBrandAndCarType(String brand, String carType);
     List<Car> findByStatus(CarStatus status);
//     List<CarDto> findMinimum(long minimum);
}
