package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.integration.rest.CarFleetRestTemplate;
import com.example.CarRentalApplication.integration.rest.CarResponseDtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CarService implements ICarService{

    private final Logger logger = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarFleetRestTemplate carFleetRestTemplate;

    @Override
    public CarResponseDtos getCars(Map<String, String> params) {
        return carFleetRestTemplate.getCars(params);
    }
}
