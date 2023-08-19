package com.example.CarRentalApplication.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    public void send(String email, String message) {
        logger.info(
                String.format(
                        "Sending email to %s, with content %s.",
                        email,
                        message
                )
        );
    }
}
