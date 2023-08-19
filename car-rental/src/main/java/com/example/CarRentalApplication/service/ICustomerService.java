package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.service.dto.request.CreditCardRequestDto;
import com.example.CarRentalApplication.service.dto.request.CustomerRequestDto;
import com.example.CarRentalApplication.service.dto.response.CreditCardResponseDto;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDto;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    CustomerResponseDto addCustomer(CustomerRequestDto requestDto);

    CustomerResponseDto updateCustomer(String customerNumber, CustomerRequestDto requestDto);

    void deleteCustomer(String customerNumber);

    CustomerResponseDto getCustomerByCustomerNumber(String customerNumber);

    List<CustomerResponseDto> getCustomers(Map<String, String> params);

    CreditCardResponseDto addCreditCard(CreditCardRequestDto requestDto);
}
