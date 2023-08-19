package com.example.CarRentalApplication.controller;

import com.example.CarRentalApplication.domain.Customer;
import com.example.CarRentalApplication.integration.jms.JSMSenderService;
import com.example.CarRentalApplication.integration.rest.CarResponseDtos;
import com.example.CarRentalApplication.repository.CustomerRepository;
import com.example.CarRentalApplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarSearchController {
    @Autowired
    private CarService carService;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private JSMSenderService JSMSenderService;


    @GetMapping
    public ResponseEntity<CarResponseDtos> getCars(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(carService.getCars(params), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testingJMS() {
//        carDataJSMSender.sendTest("JUST A TEST MESSAGE OVER JSM");
        Customer customer = new Customer("customer-X1","customer-X1@gmail.com");
//        customerRepository.save(customer);
//        Customer customer =customerRepository.findByName("customer1");
        System.out.println(customer);
        JSMSenderService.send("A", false, customer);
        return new ResponseEntity<>("SENDING MESSAGE", HttpStatus.OK);
    }
}
