package com.joshimo.cinema.enity.implementation;

import com.joshimo.cinema.enity.EntityRequestResponseConverter;
import com.joshimo.cinema.enity.Film;
import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.dto.SeanceRequest;
import com.joshimo.cinema.enity.dto.SeanceResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("seanceRequestResponseConverter")
public class SeanceRequestResponseConverter implements EntityRequestResponseConverter<SeanceRequest, Seance, SeanceResponse> {

    @Override
    public Seance requestToEntity(SeanceRequest request) {
        Seance seance = new Seance();
        seance.setFilmId(request.getFilmId());
        seance.setSchedule(request.getSchedule());
        return seance;
    }

    @Override
    public SeanceResponse entityToResponse(Seance seance) {
        SeanceResponse response = new SeanceResponse();
        response.setSeanceId(seance.getSeanceId());
        response.setSchedule(seance.getSchedule());
        response.setFilmInfo(seance.getFilm().getInfo());
        response.setFilmName(seance.getFilm().getName());
        response.setFilmNotes(seance.getFilm().getNotes());
        return response;
    }
}
