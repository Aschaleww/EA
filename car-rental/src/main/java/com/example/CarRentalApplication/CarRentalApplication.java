package com.example.CarRentalApplication;

import com.example.CarRentalApplication.domain.Customer;
import com.example.CarRentalApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJms
@EnableScheduling
@SpringBootApplication
public class CarRentalApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer("customer1","customer1@gmail.com");
		customerRepository.save(customer);
		 customer = new Customer("customer2","customer2@gmail.com");
		customerRepository.save(customer);
	}
}
