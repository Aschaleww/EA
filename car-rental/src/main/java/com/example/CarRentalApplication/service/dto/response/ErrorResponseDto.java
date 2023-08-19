package com.example.CarRentalApplication.service.dto.response;

public class ErrorResponseDto {
    private String errorMessage;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
