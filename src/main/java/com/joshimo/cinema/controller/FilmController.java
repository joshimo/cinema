package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.Film;
import com.joshimo.cinema.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class FilmController {

    private FilmService filmService;

    @Resource(name = "filmService")
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    /** Film services */

    @GetMapping("/film/show/all")
    public List<Film> findAllFilms() {
        return filmService.findAllFilms();
    }

    @GetMapping("/film/show/{id}")
    public Film findFilmById(@PathVariable Long id) {
        return filmService.findFilmById(id);
    }

    @PostMapping("/film/add")
    public ResponseEntity addFilm(@RequestBody Film film) {
        Film addedFilm = filmService.addNewFilm(film);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedFilm.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/film/delete/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.removeFilmById(id);
    }
}
