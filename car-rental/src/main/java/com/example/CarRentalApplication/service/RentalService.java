package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.domain.CreditCard;
import com.example.CarRentalApplication.domain.Customer;
import com.example.CarRentalApplication.domain.Payment;
import com.example.CarRentalApplication.domain.RentalEntry;
import com.example.CarRentalApplication.domain.RentalStatus;
import com.example.CarRentalApplication.domain.ReservationEntry;
import com.example.CarRentalApplication.domain.ReservationStatus;
import com.example.CarRentalApplication.integration.jms.JSMSenderService;
import com.example.CarRentalApplication.integration.rest.CarFleetRestTemplate;
import com.example.CarRentalApplication.integration.rest.CarResponseDto;
import com.example.CarRentalApplication.repository.CreditCardRepository;
import com.example.CarRentalApplication.repository.CustomerRepository;
import com.example.CarRentalApplication.repository.RentalEntryRepository;
import com.example.CarRentalApplication.repository.ReservationEntryRepository;
import com.example.CarRentalApplication.service.dto.request.AddPaymentRequestDto;
import com.example.CarRentalApplication.service.dto.request.RentalRequestDto;
import com.example.CarRentalApplication.service.dto.request.ReturnRequestDto;
import com.example.CarRentalApplication.service.dto.response.CarRentalHistoryResponseDto;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDto;
import com.example.CarRentalApplication.service.dto.response.RentalEntryResponseDto;
import com.example.CarRentalApplication.service.exception.CarNotAvailableException;
import com.example.CarRentalApplication.service.exception.CreditCardNotFoundException;
import com.example.CarRentalApplication.service.exception.CustomerNotFoundException;
import com.example.CarRentalApplication.service.exception.RentalNotFoundException;
import com.example.CarRentalApplication.service.exception.ReservationNotFoundException;
import com.example.CarRentalApplication.service.mapper.MapperRentalEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@Service
public class RentalService implements IRentalService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalEntryRepository rentalEntryRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CarFleetRestTemplate carFleetRestTemplate;

    @Autowired
    private MapperRentalEntryDto mapperRentalEntryDto;

    @Autowired
    private ReservationEntryRepository reservationEntryRepository;

    @Autowired
    private JSMSenderService JSMSenderService;

    @Transactional
    @Override
    public RentalEntryResponseDto addRental(RentalRequestDto requestDto) {
        Customer customer = customerRepository
                .findById(Long.parseLong(requestDto.getCustomerNumber()))
                .orElseThrow(() -> new CustomerNotFoundException("Customer does not exist."));

        String licensePlate = requestDto.getLicensePlate();

        LocalDate pickupDate = LocalDate.now();
        LocalDate returnedDate = requestDto.getReturnedDate();

        if(Objects.isNull(requestDto.getReservationId())) { // no reservation
            CarResponseDto carResponseDto = carFleetRestTemplate.getCarByLicensePlate(licensePlate);
            if (!carResponseDto.getAvailability()) {
                throw new CarNotAvailableException("Car is not available.");
            }
        } else {
            ReservationEntry reservationEntry = reservationEntryRepository
                    .findById(Long.parseLong(requestDto.getReservationId()))
                    .orElseThrow(() -> new ReservationNotFoundException("Reservation does not exist."));
            reservationEntry.setStatus(ReservationStatus.COMPLETE);
            reservationEntryRepository.save(reservationEntry);
            returnedDate = reservationEntry.getReturnedDate();
            licensePlate = reservationEntry.getLicensePlate();
        }

        RentalEntry rentalEntry = new RentalEntry(
                licensePlate,
                pickupDate,
                returnedDate,
                RentalStatus.AVAILABLE
        );
        rentalEntry.setCustomer(customer);
        rentalEntryRepository.save(rentalEntry);


        JSMSenderService.send(licensePlate, false ,customer);

        return mapperRentalEntryDto.map(rentalEntry);
    }

    @Transactional
    @Override
    public RentalEntryResponseDto returnCar(ReturnRequestDto requestDto) {
        RentalEntry rentalEntry = rentalEntryRepository
                .findById(Long.parseLong(requestDto.getRentalEntryId()))
                .orElseThrow(() -> new RentalNotFoundException("Rental entry does not exist."));

        rentalEntry.setStatus(RentalStatus.RESERVED);
        rentalEntryRepository.save(rentalEntry);

        JSMSenderService.send(rentalEntry.getLicensePlate(), true,rentalEntry.getCustomer());

        return mapperRentalEntryDto.map(rentalEntry);
    }

    @Override
    public RentalEntryResponseDto addPayment(AddPaymentRequestDto requestDto) {
        RentalEntry rentalEntry = rentalEntryRepository
                .findById(Long.parseLong(requestDto.getRentalEntryId()))
                .orElseThrow(() -> new RentalNotFoundException("Rental entry does not exist."));

        CreditCard creditCard = creditCardRepository
                .findById(Long.parseLong(requestDto.getCardId()))
                .orElseThrow(() -> new CreditCardNotFoundException("Credit card does not exist."));

        CarResponseDto carResponseDto = carFleetRestTemplate.getCarByLicensePlate(rentalEntry.getLicensePlate());

        int numDay = (int) ChronoUnit.DAYS.between(rentalEntry.getPickupDate(), rentalEntry.getReturnedDate()) + 1;
        Payment payment = new Payment(carResponseDto.getPrice() * numDay, LocalDateTime.now());
        payment.setCreditCard(creditCard);

        rentalEntry.setPayment(payment);
        rentalEntryRepository.save(rentalEntry);

        return mapperRentalEntryDto.map(rentalEntry);
    }

    @Override
    public CarRentalHistoryResponseDto getRentalHistoryByCar(String licensePlate) {
        CarResponseDto carResponseDto = carFleetRestTemplate.getCarByLicensePlate(licensePlate);
        List<RentalEntryResponseDto> rentalEntryResponseDtoList = rentalEntryRepository.findByLicensePlate(licensePlate)
                .stream()
                .map(rentalEntry -> {
                    RentalEntryResponseDto responseDto = mapperRentalEntryDto.map(rentalEntry);
                    responseDto.setCustomer(
                            CustomerResponseDto.builder()
                                    .setCustomerNumber(rentalEntry.getCustomer().getCustomerNumber())
                                    .setName(rentalEntry.getCustomer().getName())
                                    .setEmail(rentalEntry.getCustomer().getEmail())
                                    .build()
                    );
                    return responseDto;
                }).toList();

        return new CarRentalHistoryResponseDto(
                carResponseDto,
                rentalEntryResponseDtoList
        );
    }
}
