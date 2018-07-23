package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.Film;
import com.joshimo.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/film")
public class FilmController {

    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    /** Film services */

    @GetMapping("/show/all")
    public List<Film> findAllFilms() {
        return filmService.findAllFilms();
    }

    @GetMapping("/show/{id}")
    public Resource<Film> findFilmById(@PathVariable Long id) {
        Film film = filmService.findFilmById(id);
        Resource<Film> filmResource = new Resource<>(film);
        ControllerLinkBuilder linkToSeance = linkTo(methodOn(SeanceController.class).findAllSeancesByFilmId(id));
        filmResource.add(linkToSeance.withRel("seances"));
        return filmResource;
    }

    @PostMapping("/add")
    public ResponseEntity addFilm(@RequestBody Film film) {
        Film addedFilm = filmService.addNewFilm(film);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedFilm.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.removeFilmById(id);
    }
}
