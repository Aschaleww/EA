package com.example.CarRentalApplication.service.mapper;

import com.example.CarRentalApplication.domain.Payment;
import com.example.CarRentalApplication.service.dto.response.PaymentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperPaymentDto implements Mapper<Payment, PaymentResponseDto> {

    @Autowired
    private MapperCreditCardDto mapperCreditCardDto;

    @Override
    public PaymentResponseDto map(Payment from) {
        if (from == null) return null;
        return new PaymentResponseDto(
                from.getId(),
                from.getAmount(),
                from.getDateTime(),
                mapperCreditCardDto.map(from.getCreditCard())
        );
    }
}
