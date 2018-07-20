package com.joshimo.cinema.service.implementation;

import com.joshimo.cinema.enity.Film;
import com.joshimo.cinema.exception.NoSuchFilmException;
import com.joshimo.cinema.repository.FilmRepository;
import com.joshimo.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("filmService")
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film findFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new NoSuchFilmException());
    }

    @Override
    public Film addNewFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void removeFilmById(Long id) {
        try {
            filmRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchFilmException();
        }
    }

    @Override
    public void removeFilm(Film film) {
        try {
            filmRepository.delete(film);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchFilmException();
        }
    }
}
