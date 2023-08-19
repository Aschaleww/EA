package com.example.CarRentalApplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class RentalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String licensePlate;

    private LocalDate pickupDate;

    private LocalDate returnedDate;

    private RentalStatus status;

    @ManyToOne
    @JoinColumn(name = "customerNumber")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public RentalEntry() {
    }

    public RentalEntry(String licensePlate, LocalDate pickupDate, LocalDate returnedDate, RentalStatus status) {
        this.licensePlate = licensePlate;
        this.pickupDate = pickupDate;
        this.returnedDate = returnedDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
