package edu.miu.carfleet;

import edu.miu.carfleet.Domain.Car;
import edu.miu.carfleet.Domain.CarStatus;
import edu.miu.carfleet.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJms
//@EnableSwagger2
public class CarFleetApplication implements CommandLineRunner {
	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarFleetApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INITIALIZING THE SYSTEM AND CREATING SOM MOCKS CARS");
		Car car = new Car("A","Sedan","Chevrolet",100.0, CarStatus.AVAILABLE);
		carRepository.save(car);
		 car = new Car("B","SUV","Mazda",200.0, CarStatus.AVAILABLE);
		carRepository.save(car);
		car = new Car("C","HatchBack","Hyundai",300.0, CarStatus.AVAILABLE);
		carRepository.save(car);

		//		System.out.println(CarStatus.AVAILABLE);
	}
}
