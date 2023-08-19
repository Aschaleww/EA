package com.example.CarRentalApplication.integration.rest;

public class CarTypeResponseDto {
    private String type;
    private String brand;

    private Integer numCarAvailable;

    public CarTypeResponseDto() {
    }

    public CarTypeResponseDto(String type, String brand, Integer numCarAvailable) {
        this.type = type;
        this.brand = brand;
        this.numCarAvailable = numCarAvailable;
    }

    public CarTypeResponseDto(Builder builder) {
        this.type = builder.type;
        this.brand = builder.brand;
        this.numCarAvailable = builder.numCarAvailable;
    }

    public static Builder builder() {
        return new Builder();
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

    public Integer getNumCarAvailable() {
        return numCarAvailable;
    }

    public void setNumCarAvailable(Integer numCarAvailable) {
        this.numCarAvailable = numCarAvailable;
    }

    @Override
    public String toString() {
        return "CarTypeResponseDto{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", numCarAvailable=" + numCarAvailable +
                '}';
    }

    public static class Builder {
        private String type;
        private String brand;
        private Integer numCarAvailable;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setNumCarAvailable(Integer numCarAvailable) {
            this.numCarAvailable = numCarAvailable;
            return this;
        }

        public CarTypeResponseDto build() {
            return new CarTypeResponseDto(this);
        }
    }
}
