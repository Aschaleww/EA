package com.example.CarRentalApplication.service.mapper;

import com.example.CarRentalApplication.domain.CreditCard;
import com.example.CarRentalApplication.service.dto.response.CreditCardResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MapperCreditCardDto implements Mapper<CreditCard, CreditCardResponseDto> {

    @Override
    public CreditCardResponseDto map(CreditCard from) {
        if (from == null) return null;
        return new CreditCardResponseDto(
                from.getId(),
                from.getCardNumber(),
                from.getCardType()
        );
    }
}
