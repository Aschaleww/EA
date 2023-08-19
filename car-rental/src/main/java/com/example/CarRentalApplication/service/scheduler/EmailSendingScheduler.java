package com.example.CarRentalApplication.service.scheduler;

import com.example.CarRentalApplication.integration.EmailSender;
import com.example.CarRentalApplication.integration.rest.CarFleetRestTemplate;
import com.example.CarRentalApplication.integration.rest.CarTypeResponseDtos;
import com.example.CarRentalApplication.service.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSendingScheduler {
    
    @Autowired
    private EmailSender emailSender;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private CarFleetRestTemplate carFleetRestTemplate;
    
//    @Scheduled(fixedRate = 3600000) // 60 minute
    public void execute() {
        CarTypeResponseDtos carTypeResponseDtos =
                carFleetRestTemplate.getCarTypesInShortage(applicationProperties.getMinimumCarAvailable());

        emailSender.send(applicationProperties.getFleetManagerEmail(),   carTypeResponseDtos.toString());

    }
}
