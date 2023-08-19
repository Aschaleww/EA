package com.example.CarRentalApplication.integration.rest;

import java.util.List;

public class CarTypeResponseDtos {
   private List<CarTypeResponseDto> carTypes;

   public CarTypeResponseDtos() {
   }

   public CarTypeResponseDtos(List<CarTypeResponseDto> carTypes) {
      this.carTypes = carTypes;
   }

   public List<CarTypeResponseDto> getCarTypes() {
      return carTypes;
   }

   public void setCarTypes(List<CarTypeResponseDto> carTypes) {
      this.carTypes = carTypes;
   }

   @Override
   public String toString() {
      return "CarTypeResponseDtos{" +
              "carTypes=" + carTypes +
              '}';
   }
}
