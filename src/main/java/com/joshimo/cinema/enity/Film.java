package com.joshimo.cinema.enity;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "film_name")
    private String name;

    @Basic
    @Column(name = "film_info")
    private String info;

    @Basic
    @Column(name = "film_notes")
    private String notes;

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Long id) {
        id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}