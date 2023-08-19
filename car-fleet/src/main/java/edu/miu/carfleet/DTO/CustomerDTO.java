package edu.miu.carfleet.DTO;

public class CustomerDTO {
    private Long customernumber;
    private String name;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(Long customernumber, String name, String email) {
        this.customernumber = customernumber;
        this.name = name;
        this.email = email;
    }

    public Long getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Long customernumber) {
        this.customernumber = customernumber;
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
}
