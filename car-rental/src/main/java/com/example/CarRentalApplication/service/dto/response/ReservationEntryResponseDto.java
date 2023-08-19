package com.example.CarRentalApplication.service.dto.response;

import com.example.CarRentalApplication.domain.ReservationStatus;

import java.time.LocalDate;
import java.util.UUID;

public class ReservationEntryResponseDto {
    private long id;

    private String licensePlate;

    private LocalDate pickupDate;

    private LocalDate returnedDate;

    private ReservationStatus status;

    public ReservationEntryResponseDto() {
    }

    public ReservationEntryResponseDto(long id, String licensePlate, LocalDate pickupDate, LocalDate returnedDate, ReservationStatus status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.pickupDate = pickupDate;
        this.returnedDate = returnedDate;
        this.status = status;
    }

    public ReservationEntryResponseDto(Builder builder) {
        this.id = builder.id;
        this.licensePlate = builder.licensePlate;
        this.pickupDate = builder.pickupDate;
        this.returnedDate = builder.returnedDate;
        this.status = builder.status;
    }

    public static Builder builder(){
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public static class Builder {
        private long id;

        private String licensePlate;

        private LocalDate pickupDate;

        private LocalDate returnedDate;

        private ReservationStatus status;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setPickupDate(LocalDate pickupDate) {
            this.pickupDate = pickupDate;
            return this;
        }

        public Builder setReturnedDate(LocalDate returnedDate) {
            this.returnedDate = returnedDate;
            return this;
        }

        public Builder setStatus(ReservationStatus status) {
            this.status = status;
            return this;
        }

        public ReservationEntryResponseDto build() {
            return new ReservationEntryResponseDto(this);
        }
    }
}
