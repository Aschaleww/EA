package com.example.CarRentalApplication.integration.rest;

import com.example.CarRentalApplication.service.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CarFleetRestTemplate {
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    public CarFleetRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .errorHandler(new CarFleetRestTemplateResponseErrorHandler())
                .build();
    }

    public CarResponseDto getCarByLicensePlate(String licensePlate) {
        return restTemplate
                .getForObject(
                        applicationProperties.getCarFleetUrl() + "/cars/{licensePlate}",
                        CarResponseDto.class,
                        licensePlate
                );
    }

    public CarTypeResponseDtos getCarTypesInShortage(Integer minimum) {
        return restTemplate
                .getForObject(
                        applicationProperties.getCarFleetUrl() + "/cars/carTypes/shortage/{minimum}",
                        CarTypeResponseDtos.class,
                        minimum
                );
    }

    public CarResponseDtos getCars(Map<String, String> params) {
        String requestParams = params.keySet().stream()
                .map(key -> key + "=" + params.get(key))
                .collect(Collectors.joining("&"));
        String path = requestParams.isEmpty() ? "/cars" : "/cars?" + requestParams;
        return restTemplate
                .getForObject(
                        applicationProperties.getCarFleetUrl() + path,
                        CarResponseDtos.class
                );
    }
}
