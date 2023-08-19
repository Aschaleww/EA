package edu.miu.carfleet.service;

import edu.miu.carfleet.DTO.CarAdapter;
import edu.miu.carfleet.DTO.CarDto;
import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Exception.NotFoundException;
import edu.miu.carfleet.Repository.CarRepository;
import edu.miu.carfleet.Service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CarServiceTests {
    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @TestConfiguration
    static class AccountServiceTestConfiguration {
        @Bean
        public CarAdapter carAdapter(){return new CarAdapter();}
        @Bean
        public CarService carService() {
            return new CarService();
        }
    }

    @Before
    public void setup() {
        Car testCar = new Car();
        testCar.setLicensePlate("abcd1234");
        testCar.setBrand("toyota");
        testCar.setType("sedan");
        testCar.setPrice(30000.00);
        Mockito.when(carRepository.findByLicensePlate("abcd1234")).thenReturn(testCar);
    }

    @Test
    public void whenFindCarByPlateWithAValidPlate_thenReturnTheCar() {
        final String testPlate = "abcd1234";
        CarDto car = carService.findCarByPlate(testPlate);
        assertThat(car.getLicensePlate()).isEqualTo(testPlate);
        assertThat(car.getBrand()).isEqualTo("toyota");
        assertThat(car.getPrice()).isEqualTo(30000);
    }

    @Test(expected = NotFoundException.class)
    public void whenFindCarByPlateWithAnInvalidPlate_thenDoNotReturnTheCar() {
        final String testPlate = "abcd4567";
        CarDto car = carService.findCarByPlate(testPlate);
    }
}

