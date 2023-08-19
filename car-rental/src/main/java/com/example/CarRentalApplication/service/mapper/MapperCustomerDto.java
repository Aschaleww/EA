package com.example.CarRentalApplication.service.mapper;

import com.example.CarRentalApplication.domain.Customer;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperCustomerDto implements Mapper<Customer, CustomerResponseDto> {

    @Autowired
    private MapperCreditCardDto mapperCreditCardDto;

    @Autowired
    private MapperReservationEntryDto mapperReservationEntryDto;

    @Autowired
    private MapperRentalEntryDto mapperRentalEntryDto;

    @Override
    public CustomerResponseDto map(Customer from) {
        if (from == null) return null;
        return new CustomerResponseDto(
                from.getCustomerNumber(),
                from.getName(),
                from.getEmail(),
                mapperReservationEntryDto.map(from.getReservationEntryList()),
                null,
                mapperCreditCardDto.map(from.getCreditCardList())
        );
    }
}
