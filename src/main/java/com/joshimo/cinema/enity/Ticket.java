package com.joshimo.cinema.enity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Basic
    @Column(name = "seance_id")
    private Long seanceId;

    @Basic
    @Column(name = "cost")
    private Double cost;

    @Transient
    private Boolean isReserved;

    @Basic
    @Column(name = "row_number")
    private Integer rowNumber;

    @Basic
    @Column(name = "seat_number")
    private Integer seatNumber;

    /** constructor */
    public Ticket() {
    }

    /** getters */
    public Long getTicketId() {
        return ticketId;
    }

    public Long getSeanceId() {
        return seanceId;
    }

    public Double getCost() {
        return cost;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    /** setters */
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!seanceId.equals(ticket.seanceId)) return false;
        if (!rowNumber.equals(ticket.rowNumber)) return false;
        return seatNumber.equals(ticket.seatNumber);
    }

    @Override
    public int hashCode() {
        int result = seanceId.hashCode();
        result = 31 * result + rowNumber.hashCode();
        result = 31 * result + seatNumber.hashCode();
        return result;
    }
}
