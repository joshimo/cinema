package com.joshimo.cinema.enity.dto;

import javax.validation.constraints.Size;

public class SeanceRequest {

    private Long filmId;
    @Size(min = 14, max = 28)
    private String schedule;

    public SeanceRequest() {
    }

    public SeanceRequest(Long filmId, String schedule) {
        this.filmId = filmId;
        this.schedule = schedule;
    }

    public Long getFilmId() {
        return filmId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
