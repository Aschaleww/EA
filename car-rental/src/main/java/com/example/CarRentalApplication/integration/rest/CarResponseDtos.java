package com.example.CarRentalApplication.integration.rest;

import java.util.List;

public class CarResponseDtos {
   private List<CarResponseDto> cars;

   public CarResponseDtos() {
   }

   public CarResponseDtos(List<CarResponseDto> cars) {
      this.cars = cars;
   }

   public List<CarResponseDto> getCars() {
      return cars;
   }

   public void setCars(List<CarResponseDto> cars) {
      this.cars = cars;
   }

   @Override
   public String toString() {
      return "CarResponseDtos{" +
              "cars=" + cars +
              '}';
   }
}
