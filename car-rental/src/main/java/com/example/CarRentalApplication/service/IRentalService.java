package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.service.dto.request.AddPaymentRequestDto;
import com.example.CarRentalApplication.service.dto.request.RentalRequestDto;
import com.example.CarRentalApplication.service.dto.request.ReturnRequestDto;
import com.example.CarRentalApplication.service.dto.response.CarRentalHistoryResponseDto;
import com.example.CarRentalApplication.service.dto.response.RentalEntryResponseDto;

public interface IRentalService {
    RentalEntryResponseDto addRental(RentalRequestDto requestDto);

    RentalEntryResponseDto returnCar(ReturnRequestDto requestDto);

    CarRentalHistoryResponseDto getRentalHistoryByCar(String licensePlate);

    RentalEntryResponseDto addPayment(AddPaymentRequestDto requestDto);
}
