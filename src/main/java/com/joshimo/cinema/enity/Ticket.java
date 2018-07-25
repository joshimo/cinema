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

    /*@Basic
    @Column(name = "user_id")
    private Long userId;*/

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_number")
    private Seat seat;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "row_number")
    private Row row;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

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

    /*public Long getUserId() {
        return userId;
    }*/

    public Row getRow() {
        return row;
    }

    public Seat getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }

    /** setters */
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    /*public void setUserId(Long userId) {
        this.userId = userId;
    }*/

    public void setRow(Row row) {
        this.row = row;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setUser(User user) {
        this.user = user;
    }
}