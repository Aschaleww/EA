package com.example.CarRentalApplication.integration.rest;

public class CarResponseDto {
    private String licensePlate;
    private String type;
    private String brand;
    private Double price;
    private Boolean availability;

    public CarResponseDto() {
    }

    public CarResponseDto(String licensePlate, String type, String brand, Double price, Boolean availability) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.availability = availability;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "CarResponseDto{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }
}
