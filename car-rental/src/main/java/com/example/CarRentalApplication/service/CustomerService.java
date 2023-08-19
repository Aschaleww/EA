package com.example.CarRentalApplication.service;

import com.example.CarRentalApplication.domain.CreditCard;
import com.example.CarRentalApplication.domain.Customer;
import com.example.CarRentalApplication.repository.CreditCardRepository;
import com.example.CarRentalApplication.repository.CustomerRepository;
import com.example.CarRentalApplication.service.dto.request.CreditCardRequestDto;
import com.example.CarRentalApplication.service.dto.request.CustomerRequestDto;
import com.example.CarRentalApplication.service.dto.response.CreditCardResponseDto;
import com.example.CarRentalApplication.service.dto.response.CustomerResponseDto;
import com.example.CarRentalApplication.service.exception.CustomerNotFoundException;
import com.example.CarRentalApplication.service.mapper.MapperCreditCardDto;
import com.example.CarRentalApplication.service.mapper.MapperCustomerDto;
import com.example.CarRentalApplication.service.mapper.MapperRentalEntryDto;
import com.example.CarRentalApplication.service.mapper.MapperReservationEntryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MapperCustomerDto mapperCustomerDto;

    @Autowired
    private MapperRentalEntryDto mapperRentalEntryDto;

    @Autowired
    private MapperCreditCardDto mapperCreditCardDto;

    @Autowired
    private MapperReservationEntryDto mapperReservationEntryDto;

    @Autowired
    private CreditCardRepository creditCardRepository;

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Transactional
    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto requestDto) {
        Customer customer = new Customer(requestDto.getName(), requestDto.getEmail());
        customerRepository.save(customer);
        return CustomerResponseDto.builder()
                .setCustomerNumber(customer.getCustomerNumber())
                .setName(customer.getName())
                .setEmail(customer.getEmail())
                .build();
    }

    @Transactional
    @Override
    public CustomerResponseDto updateCustomer(String customerNumber, CustomerRequestDto requestDto) {
        Customer customer = customerRepository
                .findById(Long.parseLong(customerNumber))
                .orElseThrow(() -> new CustomerNotFoundException("Customer does not exist."));

        customer.setName(requestDto.getName());
        customer.setEmail(requestDto.getEmail());
        customerRepository.save(customer);

        return CustomerResponseDto.builder()
                .setCustomerNumber(customer.getCustomerNumber())
                .setName(customer.getName())
                .setEmail(customer.getEmail())
                .build();
    }

    @Transactional
    @Override
    public void deleteCustomer(String customerNumber) {
        Customer customer = customerRepository
                .findById(Long.parseLong(customerNumber))
                .orElseThrow(() -> new CustomerNotFoundException("Customer does not exist."));

        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponseDto getCustomerByCustomerNumber(String customerNumber) {
        Customer customer = customerRepository
                .findById(Long.parseLong(customerNumber))
                .orElseThrow(() -> new CustomerNotFoundException("Customer does not exist."));
        return CustomerResponseDto.builder()
                .setCustomerNumber(customer.getCustomerNumber())
                .setName(customer.getName())
                .setEmail(customer.getEmail())
                .setReservationEntryList(mapperReservationEntryDto.map(customer.getReservationEntryList()))
                .setCreditCardList(mapperCreditCardDto.map(customer.getCreditCardList()))
                .setRentalEntryList(mapperRentalEntryDto.map(customer.getRentalEntryList()))
                .build();
    }

    @Override
    public List<CustomerResponseDto> getCustomers(Map<String, String> params) {
        Stream<Customer> stream = customerRepository.findAll().stream();
        stream = params.get("name") == null ? stream : filterByName(stream, params.get("name"));
        stream = params.get("email") == null ? stream : filterByEmail(stream, params.get("email"));
        return stream.map(customer -> CustomerResponseDto.builder()
                        .setCustomerNumber(customer.getCustomerNumber())
                        .setName(customer.getName())
                        .setEmail(customer.getEmail())
                        .setReservationEntryList(mapperReservationEntryDto.map(customer.getReservationEntryList()))
                        .setCreditCardList(mapperCreditCardDto.map(customer.getCreditCardList()))
                        .setRentalEntryList(mapperRentalEntryDto.map(customer.getRentalEntryList()))
                        .build())
                .collect(Collectors.toList());
    }

    private Stream<Customer> filterByName(Stream<Customer> stream, String name) {
        return stream.filter((customer) -> Objects.equals(customer.getName(), name));
    }

    private Stream<Customer> filterByEmail(Stream<Customer> stream, String email) {
        return stream.filter((customer) -> Objects.equals(customer.getEmail(), email));
    }

    @Transactional
    @Override
    public CreditCardResponseDto addCreditCard(CreditCardRequestDto requestDto) {
        Customer customer = customerRepository
                .findById(Long.parseLong(requestDto.getCustomerNumber()))
                .orElseThrow(() -> new CustomerNotFoundException("Customer does not exists."));

        CreditCard creditCard = new CreditCard(requestDto.getCardNumber(), requestDto.getCardType());

        creditCardRepository.save(creditCard);
        customer.addCreditCard(creditCard);
        customerRepository.save(customer);

        return mapperCreditCardDto.map(creditCard);
    }
}
