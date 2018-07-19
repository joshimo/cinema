package com.joshimo.cinema.enity.dto;

public class SeanceRequest {

    private Long filmId;
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
