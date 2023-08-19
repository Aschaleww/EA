package com.example.CarRentalApplication.service.dto.response;

import com.example.CarRentalApplication.domain.RentalStatus;

import java.time.LocalDate;
import java.util.UUID;

public class RentalEntryResponseDto {
    private long id;

    private String licensePlate;

    private LocalDate pickupDate;

    private LocalDate returnedDate;

    private RentalStatus status;

    private CustomerResponseDto customer;

    private PaymentResponseDto payment;

    public RentalEntryResponseDto() {
    }

    public RentalEntryResponseDto(long id, String licensePlate, LocalDate pickupDate, LocalDate returnedDate, RentalStatus status, CustomerResponseDto customer, PaymentResponseDto payment) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.pickupDate = pickupDate;
        this.returnedDate = returnedDate;
        this.status = status;
        this.customer = customer;
        this.payment = payment;
    }

    public RentalEntryResponseDto(Builder builder) {
        this.id = builder.id;
        this.licensePlate = builder.licensePlate;
        this.pickupDate = builder.pickupDate;
        this.returnedDate = builder.returnedDate;
        this.status = builder.status;
        this.payment = builder.payment;
        this.customer = builder.customer;
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

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public CustomerResponseDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponseDto customer) {
        this.customer = customer;
    }

    public PaymentResponseDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentResponseDto payment) {
        this.payment = payment;
    }

    public static class Builder {
        private long id;

        private String licensePlate;

        private LocalDate pickupDate;

        private LocalDate returnedDate;

        private RentalStatus status;

        private CustomerResponseDto customer;

        private PaymentResponseDto payment;

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

        public Builder setStatus(RentalStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCustomer(CustomerResponseDto customer) {
            this.customer = customer;
            return this;
        }

        public Builder setPayment(PaymentResponseDto payment) {
            this.payment = payment;
            return this;
        }

        public RentalEntryResponseDto build() {
            return new RentalEntryResponseDto(this);
        }
    }
}
