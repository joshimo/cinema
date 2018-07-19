package com.joshimo.cinema.enity.dto;

public class TicketResponse {

    private Long ticketId;
    private String schedule;
    private String filmName;
    private Double cost;
    private Integer rowNumber;
    private Integer seatNumber;

    public TicketResponse() {
    }

    public Long getTicketId() {
        return ticketId;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getFilmName() {
        return filmName;
    }

    public Double getCost() {
        return cost;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
