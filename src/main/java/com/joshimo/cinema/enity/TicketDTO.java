package com.joshimo.cinema.enity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket")
public class TicketDTO implements Serializable {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Basic
    @Column(name = "seance_id")
    private Long seanceId;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_number")
    private Seat seat;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "row_number")
    private Row row;

    /** constructor */
    public TicketDTO() {
    }

    /** getters */
    public Long getTicketId() {
        return ticketId;
    }

    public Long getSeanceId() {
        return seanceId;
    }

    public Row getRow() {
        return row;
    }

    public Seat getSeat() {
        return seat;
    }

    /** setters */
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}