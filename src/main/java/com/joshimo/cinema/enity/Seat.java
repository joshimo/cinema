package com.joshimo.cinema.enity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "seat")
public class Seat implements Serializable {

    @Id
    @Basic
    @Column (name = "seat_number")
    private Integer seatNumber;

    public Seat() {
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
