package com.example.CarRentalApplication.service.dto.response;

import java.util.UUID;

public class CreditCardResponseDto {
    private long id;

    private String cardNumber;

    private String cardType;

    private Builder builder;

    public CreditCardResponseDto() {
    }

    public CreditCardResponseDto(Builder builder) {
        this.id = builder.id;
        this.cardNumber = builder.cardNumber;
        this.cardType = builder.carType;
    }

    public CreditCardResponseDto(long id, String cardNumber, String cardType) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public static class Builder {

        private long id;

        private String cardNumber;

        private String carType;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder setCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public CreditCardResponseDto build() {
            return new CreditCardResponseDto(this);
        }
    }
}
