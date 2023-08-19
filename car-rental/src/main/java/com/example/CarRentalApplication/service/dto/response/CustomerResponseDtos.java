package com.example.CarRentalApplication.service.dto.response;

import java.util.List;

public class CustomerResponseDtos {
    private List<CustomerResponseDto> customers;

    public CustomerResponseDtos() {
    }

    public CustomerResponseDtos(List<CustomerResponseDto> customers) {
        this.customers = customers;
    }

    public List<CustomerResponseDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerResponseDto> customers) {
        this.customers = customers;
    }
}
