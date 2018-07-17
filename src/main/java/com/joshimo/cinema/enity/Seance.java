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

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private Film film;

    @Basic
    @Column(name = "seance_schedule")
    private String scedule;

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

    public Film getFilm() {
        return film;
    }

    public String getScedule() {
        return scedule;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    /** setters */
    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setScedule(String scedule) {
        this.scedule = scedule;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "seanceId=" + seanceId +
                ", scedule='" + scedule + '\'' +
                ", film='" + film + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}