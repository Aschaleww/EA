package com.example.CarRentalApplication.service.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerResponseDto {

    private long customerNumber;

    private String name;

    private String email;

    private List<ReservationEntryResponseDto> reservationEntryList = new ArrayList<>();

    private List<RentalEntryResponseDto> rentalEntryList = new ArrayList<>();

    private List<CreditCardResponseDto> creditCardList = new ArrayList<>();

    public CustomerResponseDto() {
    }

    public CustomerResponseDto(long customerNumber, String name, String email, List<ReservationEntryResponseDto> reservationEntryList, List<RentalEntryResponseDto> rentalEntryList, List<CreditCardResponseDto> creditCardList) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.email = email;
        this.reservationEntryList = reservationEntryList;
        this.rentalEntryList = rentalEntryList;
        this.creditCardList = creditCardList;
    }

    public CustomerResponseDto(Builder builder) {
        this.customerNumber = builder.customerNumber;
        this.name = builder.name;
        this.email = builder.email;;
        this.reservationEntryList = builder.reservationEntryList;
        this.rentalEntryList = builder.rentalEntryList;
        this.creditCardList = builder.creditCardList;
    }

    public static Builder builder(){
        return new Builder();
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservationEntryResponseDto> getReservationEntryList() {
        return reservationEntryList;
    }

    public void setReservationEntryList(List<ReservationEntryResponseDto> reservationEntryList) {
        this.reservationEntryList = reservationEntryList;
    }

    public List<RentalEntryResponseDto> getRentalEntryList() {
        return rentalEntryList;
    }

    public void setRentalEntryList(List<RentalEntryResponseDto> rentalEntryList) {
        this.rentalEntryList = rentalEntryList;
    }

    public List<CreditCardResponseDto> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(List<CreditCardResponseDto> creditCardList) {
        this.creditCardList = creditCardList;
    }

    public static class Builder {
        private long customerNumber;

        private String name;

        private String email;

        private List<ReservationEntryResponseDto> reservationEntryList;

        private List<RentalEntryResponseDto> rentalEntryList;

        private List<CreditCardResponseDto> creditCardList;

        public Builder setCustomerNumber(long customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setReservationEntryList(List<ReservationEntryResponseDto> reservationEntryList) {
            this.reservationEntryList = reservationEntryList;
            return this;
        }

        public Builder setRentalEntryList(List<RentalEntryResponseDto> rentalEntryList) {
            this.rentalEntryList = rentalEntryList;
            return this;
        }

        public Builder setCreditCardList(List<CreditCardResponseDto> creditCardList) {
            this.creditCardList = creditCardList;
            return this;
        }

        public CustomerResponseDto build(){
            return new CustomerResponseDto(this);
        }
    }
}
