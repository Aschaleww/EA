package com.example.CarRentalApplication.repository;


import com.example.CarRentalApplication.domain.ReservationEntry;
import com.example.CarRentalApplication.domain.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ReservationEntryRepository extends JpaRepository<ReservationEntry, Long> {
    @Modifying
    @Transactional
    @Query("update ReservationEntry re set re.status = :status where re.pickupDate = CURRENT_DATE")
    void updateReservationStatus(@Param("status") ReservationStatus status);
}
