package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.enity.UserRole;
import com.joshimo.cinema.enity.dto.SeanceRequest;
import com.joshimo.cinema.enity.dto.SeanceResponse;
import com.joshimo.cinema.enity.implementation.SeanceRequestResponseConverter;
import com.joshimo.cinema.exception.PermissionException;
import com.joshimo.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Scope("session")
@SessionAttributes("user")
@RequestMapping("/seance")
public class SeanceController {

    private SeanceService seanceService;
    private SeanceRequestResponseConverter seanceConverter;

    @Autowired
    public void setSeanceService(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @Autowired
    public void setSeanceConverter(SeanceRequestResponseConverter seanceConverter) {
        this.seanceConverter = seanceConverter;
    }

    /** Seances services */

    @GetMapping("/show/all")
    public List<Resource<SeanceResponse>> findSeances() {
        List<Resource<SeanceResponse>> seanceResources = new LinkedList<>();
        seanceService.findAllSeances().forEach((seance) -> {
            SeanceResponse response = seanceConverter.entityToResponse(seance);
            Resource<SeanceResponse> resource = new Resource<>(response);
            ControllerLinkBuilder linkToSeance = linkTo(methodOn(SeanceController.class).findSeanceById(response.getSeanceId()));
            resource.add(linkToSeance.withRel("seance-details"));
            seanceResources.add(resource);
        });
        return seanceResources;
    }

    @GetMapping("/show/allByFilmId/{id}")
    public List<Resource<SeanceResponse>> findAllSeancesByFilmId(@PathVariable Long id) {
        List<Resource<SeanceResponse>> seanceResources = new LinkedList<>();
        seanceService.findAllByFilmId(id).forEach((seance) -> {
            SeanceResponse response = seanceConverter.entityToResponse(seance);
            Resource<SeanceResponse> resource = new Resource<>(response);
            ControllerLinkBuilder linkToSeance = linkTo(methodOn(SeanceController.class).findSeanceById(response.getSeanceId()));
            resource.add(linkToSeance.withRel("seance-details"));
            seanceResources.add(resource);
        });
        return seanceResources;
    }

    @GetMapping("/show/{id}")
    public Resource<SeanceResponse> findSeanceById(@PathVariable Long id) {
        Seance seance = seanceService.findSeanceById(id);
        Long filmId = seance.getFilmId();
        SeanceResponse seanceResponse = seanceConverter.entityToResponse(seance);
        Resource<SeanceResponse> seanceResource = new Resource<>(seanceResponse);
        ControllerLinkBuilder linkToFilm = linkTo(methodOn(FilmController.class).findFilmById(filmId));
        seanceResource.add(linkToFilm.withRel("film"));
        ControllerLinkBuilder linkToAllSeances = linkTo(methodOn(SeanceController.class).findSeances());
        seanceResource.add(linkToAllSeances.withRel("all-seances"));
        return seanceResource;
    }

    @PostMapping("/add")
    public ResponseEntity addSeance(@Valid @RequestBody SeanceRequest request, @SessionAttribute("user") User user) {
        if (user.getUserRole() != UserRole.ADMIN) {
            throw new PermissionException();
        }
        Seance seance = seanceConverter.requestToEntity(request);
        Seance created = seanceService.addNewSeance(seance);
        URI location = ServletUriComponentsBuilder.fromPath("/seance/show/{id}").buildAndExpand(created.getSeanceId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/cancel/{id}")
    public void cancelSeance(@PathVariable Long id, @SessionAttribute("user") User user) {
        if (user.getUserRole() != UserRole.ADMIN) {
            throw new PermissionException();
        }
        seanceService.removeSeanceById(id);
    }
}