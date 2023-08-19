package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.integration.rest.CarResponseDtos;

import java.util.Map;

public interface ICarService {
    CarResponseDtos getCars(Map<String, String> map);
}
