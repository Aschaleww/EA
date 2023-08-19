package edu.miu.carfleet.DTO;

import java.time.LocalDate;

public class ReservationDTO {
    private Long id;
    private Long customerid;
    private long carid;
    private LocalDate startDate;
    private LocalDate endDate;

    public ReservationDTO() {
    }

    public ReservationDTO(Long customerid, long carid, LocalDate startDate, LocalDate endDate) {
        this.customerid = customerid;
        this.carid = carid;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public long getCarid() {
        return carid;
    }

    public void setCarid(long carid) {
        this.carid = carid;
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
}
