package edu.miu.dto;

public class FrequentRenterDTO{
    private long customerId;
    private String username;
    private String password;
    private Integer point;
    private String accountType;


    public FrequentRenterDTO(long customerId, String username, String password, Integer point, String accountType) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.point = point;
        this.accountType = accountType;
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