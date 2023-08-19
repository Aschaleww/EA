package com.example.CarRentalApplication.repository;


import com.example.CarRentalApplication.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
