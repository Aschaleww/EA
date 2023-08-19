package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.domain.Customer;
import com.example.CarRentalApplication.domain.ReservationEntry;
import com.example.CarRentalApplication.domain.ReservationStatus;
import com.example.CarRentalApplication.integration.jms.JSMSenderService;
import com.example.CarRentalApplication.integration.rest.CarFleetRestTemplate;
import com.example.CarRentalApplication.repository.CustomerRepository;
import com.example.CarRentalApplication.repository.RentalEntryRepository;
import com.example.CarRentalApplication.repository.ReservationEntryRepository;
import com.example.CarRentalApplication.service.dto.request.ReservationRequestDto;
import com.example.CarRentalApplication.service.dto.response.ReservationEntryResponseDto;
import com.example.CarRentalApplication.service.exception.CustomerNotFoundException;
import com.example.CarRentalApplication.service.exception.MaximumReservationExceedingException;
import com.example.CarRentalApplication.service.mapper.MapperReservationEntryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MapperReservationEntryDto mapperReservationEntryDto;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private CarFleetRestTemplate carFleetRestTemplate;

    @Autowired
    private JSMSenderService JSMSenderService;

    @Autowired
    private ReservationEntryRepository reservationEntryRepository;

    @Autowired
    private RentalEntryRepository rentalEntryRepository;

    private final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    @Transactional
    @Override
    public ReservationEntryResponseDto addReservation(ReservationRequestDto requestDto) {
        Customer customer = customerRepository
                .findById(Long.parseLong(requestDto.getCustomerNumber()))
                .orElseThrow(() -> new CustomerNotFoundException("Customer does not exists."));

        carFleetRestTemplate.getCarByLicensePlate(requestDto.getLicensePlate());

        int numReservation = (int) customer.getReservationEntryList().stream().filter((re -> re.getStatus() == ReservationStatus.VALID)).count();
        if (numReservation > applicationProperties.getMaximumReservation()) {
            throw new MaximumReservationExceedingException("Number of reservations surpasses.");
        }

        ReservationEntry reservationEntry = new ReservationEntry(
                requestDto.getLicensePlate(),
                requestDto.getPickupDate(),
                requestDto.getReturnedDate(),
                ReservationStatus.VALID
        );
        reservationEntryRepository.save(reservationEntry);
        customer.addReservationEntry(reservationEntry);
        customerRepository.save(customer);

        return mapperReservationEntryDto.map(reservationEntry);
    }
}
