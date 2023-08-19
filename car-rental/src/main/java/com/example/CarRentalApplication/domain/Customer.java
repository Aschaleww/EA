package com.example.CarRentalApplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerNumber;

    private String name;

    private String email;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "customerNumber")
    private List<ReservationEntry> reservationEntryList = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<RentalEntry> rentalEntryList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "customerNumber")
    private List<CreditCard> creditCardList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addReservationEntry(ReservationEntry entry) {
        this.reservationEntryList.add(entry);
    }

    public void addRentalEntry(RentalEntry entry) {
        this.rentalEntryList.add(entry);
    }

    public void addCreditCard(CreditCard card) {
        this.creditCardList.add(card);
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReservationEntry> getReservationEntryList() {
        return reservationEntryList;
    }

    public void setReservationEntryList(List<ReservationEntry> reservationEntryList) {
        this.reservationEntryList = reservationEntryList;
    }

    public List<RentalEntry> getRentalEntryList() {
        return rentalEntryList;
    }

    public void setRentalEntryList(List<RentalEntry> rentalEntryList) {
        this.rentalEntryList = rentalEntryList;
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", reservationEntryList=" + reservationEntryList +
                ", rentalEntryList=" + rentalEntryList +
                ", creditCardList=" + creditCardList +
                '}';
    }
}
