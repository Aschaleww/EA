package com.example.CarRentalApplication.service.dto.request;

public class CreditCardRequestDto {
    private String customerNumber;
    private String cardNumber;
    private String cardType;

    public CreditCardRequestDto() {
    }

    public CreditCardRequestDto(String customerNumber, String cardNumber, String cardType) {
        this.customerNumber = customerNumber;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
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

    @Override
    public String toString() {
        return "CreditCardRequestDto{" +
                "customerNumber='" + customerNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
