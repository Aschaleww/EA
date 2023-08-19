package edu.miu.entity;

import jakarta.persistence.*;

@Entity
public class CustomerFrequentRenter {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private long customerId;
    private String username;
    private String password;
    private int point;
    private String accountType;

    public static final String Bronze = "Bronze";
    public static final String Silver = "Silver";
    public static final String Gold = "Gold";

    protected CustomerFrequentRenter() {}

    public CustomerFrequentRenter(long customerId, String username, String password) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        point = 0;
        accountType = Bronze;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
