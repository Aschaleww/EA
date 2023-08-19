package com.example.CarRentalApplication.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "application.config")
@Component
public class ApplicationProperties {
    private String fleetManagerEmail;
    private Integer maximumReservation ;
    private String carFleetUrl;

    private Integer minimumCarAvailable;

    public ApplicationProperties() {
    }

    public ApplicationProperties(String fleetManagerEmail, Integer maximumReservation, String carFleetUrl, Integer minimumCarAvailable) {
        this.fleetManagerEmail = fleetManagerEmail;
        this.maximumReservation = maximumReservation;
        this.carFleetUrl = carFleetUrl;
        this.minimumCarAvailable = minimumCarAvailable;
    }

    public String getFleetManagerEmail() {
        return fleetManagerEmail;
    }

    public void setFleetManagerEmail(String fleetManagerEmail) {
        this.fleetManagerEmail = fleetManagerEmail;
    }

    public Integer getMaximumReservation() {
        return maximumReservation;
    }

    public void setMaximumReservation(Integer maximumReservation) {
        this.maximumReservation = maximumReservation;
    }

    public String getCarFleetUrl() {
        return carFleetUrl;
    }

    public void setCarFleetUrl(String carFleetUrl) {
        this.carFleetUrl = carFleetUrl;
    }

    public Integer getMinimumCarAvailable() {
        return minimumCarAvailable;
    }

    public void setMinimumCarAvailable(Integer minimumCarAvailable) {
        this.minimumCarAvailable = minimumCarAvailable;
    }
}
