package com.example.CarRentalApplication.service.mapper;

import com.example.CarRentalApplication.domain.RentalEntry;
import com.example.CarRentalApplication.service.dto.response.RentalEntryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRentalEntryDto implements Mapper<RentalEntry, RentalEntryResponseDto> {

    @Autowired
    private MapperPaymentDto mapperPaymentDto;

    @Override
    public RentalEntryResponseDto map(RentalEntry from) {
        if (from == null) return null;
        return new RentalEntryResponseDto(
                from.getId(),
                from.getLicensePlate(),
                from.getPickupDate(),
                from.getReturnedDate(),
                from.getStatus(),
                null,
                mapperPaymentDto.map(from.getPayment())
        );
    }
}
