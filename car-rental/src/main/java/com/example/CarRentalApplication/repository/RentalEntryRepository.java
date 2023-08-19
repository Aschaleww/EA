package com.example.CarRentalApplication.repository;


import com.example.CarRentalApplication.domain.RentalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RentalEntryRepository extends JpaRepository<RentalEntry, Long> {
    List<RentalEntry> findByLicensePlate(String licensePlate);
}
