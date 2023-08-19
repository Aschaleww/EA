package edu.miu.carfleet.Domain;


import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String licensePlate;
    private String carType;
    private String brand;
    private double price;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    public Car() {
    }

    public Car(String licensePlate, String carType, String brand, double price, CarStatus status) {
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.brand = brand;
        this.price = price;

        this.status = status;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licenseplate) {
        this.licensePlate = licenseplate;
    }

    public String getType() {
        return carType;
    }

    public void setType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licenseplate='" + licensePlate + '\'' +
                ", carType='" + carType + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
