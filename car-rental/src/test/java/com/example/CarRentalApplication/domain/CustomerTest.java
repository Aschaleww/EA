package com.example.CarRentalApplication.domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void shouldAddReservationEntry(){
        customer.addReservationEntry(new ReservationEntry());
        assertThat(customer.getReservationEntryList().size(), Matchers.equalTo(1));
    }

    @Test
    public void shouldAddRentalEntry(){
        customer.addRentalEntry(new RentalEntry());
        assertThat(customer.getRentalEntryList().size(), Matchers.equalTo(1));
    }

    @Test
    public void shouldAddCreditCard(){
        customer.addCreditCard(new CreditCard());
        assertThat(customer.getCreditCardList().size(), Matchers.equalTo(1));
    }
}
