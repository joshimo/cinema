package com.joshimo.cinema.enity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seance")
public class Seance implements Serializable {

    @Id
    @Column(name = "seance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seanceId;

    @Basic
    @Column(name = "seance_date")
    private String date;

    @Basic
    @Column(name = "seance_filmname")
    private String filmName;

    @OneToMany (fetch = FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();

    /** constructors */
    public Seance() {
    }

    public Seance(Long seanceId, String date, String filmName) {
        this.seanceId = seanceId;
        this.date = date;
        this.filmName = filmName;
    }

    /** getters */
    public Long getSeanceId() {
        return seanceId;
    }

    public String getDate() {
        return date;
    }

    public String getFilmName() {
        return filmName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    /** setters */
    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}