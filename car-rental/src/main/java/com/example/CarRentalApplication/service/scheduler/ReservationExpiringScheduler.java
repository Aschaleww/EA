package com.example.CarRentalApplication.service.scheduler;

import com.example.CarRentalApplication.domain.ReservationStatus;
import com.example.CarRentalApplication.repository.ReservationEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ReservationExpiringScheduler {
    @Autowired
    private ReservationEntryRepository reservationEntryRepository;

    private final Logger logger = LoggerFactory.getLogger(ReservationExpiringScheduler.class);

    @Scheduled(cron = "* 1 10 * * *")
    public void execute() {
        logger.info("Update expired reservation at: " + LocalDateTime.now());
        reservationEntryRepository.updateReservationStatus(ReservationStatus.EXPIRED);
    }
}
