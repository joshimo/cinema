package com.joshimo.cinema.enity.dto;

public class SeanceResponse {

    private Long seanceId;
    private String schedule;
    private String filmName;
    private String filmInfo;
    private String filmNotes;

    public SeanceResponse() {
    }

    public Long getSeanceId() {
        return seanceId;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    public String getFilmNotes() {
        return filmNotes;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    public void setFilmNotes(String filmNotes) {
        this.filmNotes = filmNotes;
    }
}
