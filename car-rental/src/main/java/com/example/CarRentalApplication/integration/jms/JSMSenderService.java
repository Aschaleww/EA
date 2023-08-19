package com.example.CarRentalApplication.integration.jms;

import com.example.CarRentalApplication.domain.CarStatus;
import com.example.CarRentalApplication.domain.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JSMSenderService {
    @Autowired
    private JmsTemplate jmsTemplate;

    private Logger logger = LoggerFactory.getLogger(JSMSenderService.class);

    public void send(String licensePlate, Boolean availability, Customer customer) {


        Integer points = 20;

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("we are trying to send a message");

        try {
            CarStatus carStatus = availability ? CarStatus.AVAILABLE : CarStatus.RESERVED;
            String carData = objectMapper.writeValueAsString(new CarDataJSMEvent(licensePlate, carStatus));
            jmsTemplate.convertAndSend("carFleet", carData);

            CustomerEventData customerEventData = new CustomerEventData(
                    customer.getCustomerNumber(),
                    points, customer.getName());

            String customerData = objectMapper.writeValueAsString(customerEventData);
            jmsTemplate.convertAndSend("frequentRent", customerData);

            logger.trace("Message was sended...");
        } catch (JsonProcessingException ex) {
            logger.error("Unable to convert event to string.", ex);
        }

    }

    public void sendTest(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("we are trying to send a message");
//        try {
//            String message = objectMapper.writeValueAsString(new CarAvailabilityEvent(licensePlate, availability));

        jmsTemplate.convertAndSend("rentalSystem", message);

//        } catch (JsonProcessingException ex) {
//            logger.error("Unable to convert event to string.", ex);
//        }

    }
}
