package com.example.CarRentalApplication.controller;

import com.example.CarRentalApplication.service.ICustomerService;
import com.example.CarRentalApplication.service.dto.request.CreditCardRequestDto;
import com.example.CarRentalApplication.service.dto.request.CustomerRequestDto;
import com.example.CarRentalApplication.service.dto.response.CreditCardResponseDto;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDto;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody CustomerRequestDto requestDto) {
        CustomerResponseDto responseDto = customerService.addCustomer(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/{customerNumber}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable("customerNumber") String customerNumber, @RequestBody CustomerRequestDto requestDto) {
        CustomerResponseDto responseDto = customerService.updateCustomer(customerNumber, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("customerNumber") String customerNumber) {
        customerService.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerResponseDto> getCustomerByCustomerNumber(@PathVariable("customerNumber") String customerNumber) {
        return new ResponseEntity<>(
                customerService.getCustomerByCustomerNumber(customerNumber),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<CustomerResponseDtos> getCustomers(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(
                new CustomerResponseDtos(customerService.getCustomers(params)),
                HttpStatus.OK
        );
    }

    @PostMapping("/creditCards")
    public ResponseEntity<CreditCardResponseDto> addCreditCard(@RequestBody CreditCardRequestDto requestDto) {
        CreditCardResponseDto responseDto = customerService.addCreditCard(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
