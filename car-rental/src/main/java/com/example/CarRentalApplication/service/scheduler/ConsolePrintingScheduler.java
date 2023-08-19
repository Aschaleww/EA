package com.example.CarRentalApplication.service.scheduler;

import com.example.CarRentalApplication.integration.rest.CarFleetRestTemplate;
import com.example.CarRentalApplication.integration.rest.CarResponseDtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ConsolePrintingScheduler {
    @Autowired
    private CarFleetRestTemplate carFleetRestTemplate;

    private final Logger logger = LoggerFactory.getLogger(ConsolePrintingScheduler.class);

//    @Scheduled(cron = "*/20 * * * * *")
    public void execute() {
        CarResponseDtos responseDtos = carFleetRestTemplate.getCars(new HashMap<>());
        logger.info("All cars: " + responseDtos);
    }
}
