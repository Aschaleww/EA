package edu.miu.jms;

public class CustomerEventData {
    private long customerId;
    private int point;
    private String username;
    public CustomerEventData( ) {

    }

    public CustomerEventData(long customerId, int point, String username) {
        this.customerId = customerId;
        this.point = point;
        this.username = username;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CustomerEventData{" +
                "customerId=" + customerId +
                ", point=" + point +
                ", username='" + username + '\'' +
                '}';
    }
}
