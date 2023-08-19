package com.example.CarRentalApplication.service.dto.request;

public class ReturnRequestDto {
    private String rentalEntryId;

    public ReturnRequestDto() {
    }

    public ReturnRequestDto(String rentalEntryId) {
        this.rentalEntryId = rentalEntryId;
    }

    public String getRentalEntryId() {
        return rentalEntryId;
    }

    public void setRentalEntryId(String rentalEntryId) {
        this.rentalEntryId = rentalEntryId;
    }
}
