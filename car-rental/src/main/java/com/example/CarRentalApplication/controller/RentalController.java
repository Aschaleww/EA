package com.example.CarRentalApplication.controller;

import com.example.CarRentalApplication.service.IRentalService;
import com.example.CarRentalApplication.service.dto.request.AddPaymentRequestDto;
import com.example.CarRentalApplication.service.dto.request.RentalRequestDto;
import com.example.CarRentalApplication.service.dto.request.ReturnRequestDto;
import com.example.CarRentalApplication.service.dto.response.CarRentalHistoryResponseDto;
import com.example.CarRentalApplication.service.dto.response.RentalEntryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private IRentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalEntryResponseDto> addRental(@RequestBody RentalRequestDto requestDto) {
        RentalEntryResponseDto responseDto = rentalService.addRental(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/returns")
    public ResponseEntity<RentalEntryResponseDto> returnCar(@RequestBody ReturnRequestDto requestDto) {
        RentalEntryResponseDto responseDto = rentalService.returnCar(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/payments")
    public ResponseEntity<RentalEntryResponseDto> addPayment(@RequestBody AddPaymentRequestDto requestDto) {
        RentalEntryResponseDto responseDto = rentalService.addPayment(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @GetMapping("/cars/{licensePlate}")
    public ResponseEntity<CarRentalHistoryResponseDto> getRentalHistoryByCar(@PathVariable("licensePlate") String licensePlate) {
        CarRentalHistoryResponseDto responseDto = rentalService.getRentalHistoryByCar(licensePlate);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
