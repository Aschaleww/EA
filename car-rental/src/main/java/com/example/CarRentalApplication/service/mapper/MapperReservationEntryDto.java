package com.example.CarRentalApplication.service.mapper;

import com.example.CarRentalApplication.domain.ReservationEntry;
import com.example.CarRentalApplication.service.dto.response.ReservationEntryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MapperReservationEntryDto implements Mapper<ReservationEntry, ReservationEntryResponseDto> {

    @Override
    public ReservationEntryResponseDto map(ReservationEntry from) {
        if (from == null) return null;
        return new ReservationEntryResponseDto(
                from.getId(),
                from.getLicensePlate(),
                from.getPickupDate(),
                from.getReturnedDate(),
                from.getStatus()
        );
    }
}
