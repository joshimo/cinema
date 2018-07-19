package com.joshimo.cinema.enity.dto;

public class TicketRequest {

    private Long seanceId;
    private Integer rowNumber;
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
