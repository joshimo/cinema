package com.joshimo.cinema.service;

import com.joshimo.cinema.enity.Film;

import java.util.List;

public interface FilmService {

    List<Film> findAllFilms();

    Film findFilmById(Long id);

    Film addNewFilm(Film film);

    void removeFilmById(Long id);

    void removeFilm(Film film);
}
