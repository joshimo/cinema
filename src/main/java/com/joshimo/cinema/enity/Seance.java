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
    @Column(name = "film_id")
    private Long filmId;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    @Basic
    @Column(name = "seance_schedule")
    private String schedule;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "seance_id")
    private List<Ticket> tickets = new ArrayList<>();

    /** constructors */
    public Seance() {
    }

    /** getters */
    public Long getSeanceId() {
        return seanceId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public Film getFilm() {
        return film;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    /** setters */
    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setFilmId(Long film_id) {
        this.filmId = film_id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "seanceId=" + seanceId +
                ", scedule='" + schedule + '\'' +
                ", film='" + film + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}