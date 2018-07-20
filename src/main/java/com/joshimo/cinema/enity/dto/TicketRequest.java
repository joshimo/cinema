package com.joshimo.cinema.enity.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class TicketRequest {

    private Long seanceId;
    @Min(1)
    @Max(16)
    private Integer rowNumber;
    @Min(1)
    @Max(25)
    private Integer seatNumber;

    public TicketRequest() {
    }

    public TicketRequest(Long seanceId, Integer rowNumber, Integer seatNumber) {
        this.seanceId = seanceId;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public Long getSeanceId() {
        return seanceId;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
