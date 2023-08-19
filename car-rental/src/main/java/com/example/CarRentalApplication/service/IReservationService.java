package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.service.dto.request.ReservationRequestDto;
import com.example.CarRentalApplication.service.dto.response.ReservationEntryResponseDto;

public interface IReservationService {
    ReservationEntryResponseDto addReservation(ReservationRequestDto requestDto);
}
