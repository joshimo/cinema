package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.dto.SeanceRequest;
import com.joshimo.cinema.enity.dto.SeanceResponse;
import com.joshimo.cinema.enity.implementation.SeanceRequestResponseConverter;
import com.joshimo.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@RestController
public class SeanceController {

    private SeanceService seanceService;
    private SeanceRequestResponseConverter seanceConverter;

    @Resource(name = "seanceService")
    public void setSeanceService(SeanceService seanceService) {
        this.seanceService = seanceService;
    }


    @Autowired
    public void setSeanceConverter(SeanceRequestResponseConverter seanceConverter) {
        this.seanceConverter = seanceConverter;
    }

    /** Seances services */

    @GetMapping("/seance/show/all")
    public List<SeanceResponse> findSeances() {
        List<SeanceResponse> seances = new LinkedList<>();
        seanceService.findAllSeances().forEach((seance) -> {seances.add(seanceConverter.entityToResponse(seance));});
        return seances;
    }

    @GetMapping("/seance/show/{id}")
    public SeanceResponse findSeanceById(@PathVariable Long id) {
        return seanceConverter.entityToResponse(seanceService.findSeanceById(id));
    }

    @PostMapping("/seance/add")
    public ResponseEntity addSeance(@Valid @RequestBody SeanceRequest request) {
        Seance seance = seanceConverter.requestToEntity(request);
        Seance created = seanceService.addNewSeance(seance);
        URI location = ServletUriComponentsBuilder.fromPath("/seance/show/{id}").buildAndExpand(created.getSeanceId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/seance/cancel/{id}")
    public void cancelSeance(@PathVariable Long id) {
        seanceService.removeSeanceById(id);
    }
}
