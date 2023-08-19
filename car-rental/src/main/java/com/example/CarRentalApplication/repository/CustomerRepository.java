package com.example.CarRentalApplication.repository;


import com.example.CarRentalApplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByName(String name);
}
