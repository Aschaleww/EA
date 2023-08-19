package edu.miu.carfleet.Domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private  Customer customer;
    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
    public Reservation() {
    }
    public Reservation(LocalDate startDate, LocalDate endDate, Customer customer, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
