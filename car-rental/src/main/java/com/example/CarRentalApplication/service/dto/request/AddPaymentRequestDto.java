package com.example.CarRentalApplication.service.dto.request;

public class AddPaymentRequestDto {
    private String rentalEntryId;

    private String cardId;

    public AddPaymentRequestDto() {
    }

    public AddPaymentRequestDto(String rentalEntryId, String cardId) {
        this.rentalEntryId = rentalEntryId;
        this.cardId = cardId;
    }

    public String getRentalEntryId() {
        return rentalEntryId;
    }

    public void setRentalEntryId(String rentalEntryId) {
        this.rentalEntryId = rentalEntryId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
