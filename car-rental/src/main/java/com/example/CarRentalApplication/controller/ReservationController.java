package com.example.CarRentalApplication.controller;

import com.example.CarRentalApplication.service.ReservationService;
import com.example.CarRentalApplication.service.dto.request.ReservationRequestDto;
import com.example.CarRentalApplication.service.dto.response.ReservationEntryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationEntryResponseDto> addReservation(@RequestBody ReservationRequestDto requestDto) {
        ReservationEntryResponseDto responseDto = reservationService.addReservation(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
