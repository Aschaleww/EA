package com.example.CarRentalApplication.service.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentResponseDto {
    private long id;

    private double amount;

    private LocalDateTime dateTime;

    private CreditCardResponseDto creditCard;

    public PaymentResponseDto() {
    }

    public PaymentResponseDto(long id, double amount, LocalDateTime dateTime, CreditCardResponseDto creditCard) {
        this.id = id;
        this.amount = amount;
        this.dateTime = dateTime;
        this.creditCard = creditCard;
    }

    public static Builder builder(){
        return new Builder();
    }

    public PaymentResponseDto(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
        this.dateTime = builder.dateTime;
        this.creditCard = builder.creditCard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CreditCardResponseDto getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardResponseDto creditCard) {
        this.creditCard = creditCard;
    }

    public static class Builder {
        private long id;

        private double amount;

        private LocalDateTime dateTime;

        private CreditCardResponseDto creditCard;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setCreditCard(CreditCardResponseDto creditCard) {
            this.creditCard = creditCard;
            return this;
        }

        public PaymentResponseDto build() {
            return new PaymentResponseDto(this);
        }
    }
}
