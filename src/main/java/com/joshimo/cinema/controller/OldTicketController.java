package com.joshimo.cinema.controller;

import com.joshimo.cinema.dao.SeanceDao;
import com.joshimo.cinema.dao.TicketDao;
import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.enity.dto.SeanceRequest;
import com.joshimo.cinema.enity.dto.SeanceResponse;
import com.joshimo.cinema.enity.dto.TicketRequest;
import com.joshimo.cinema.enity.dto.TicketResponse;
import com.joshimo.cinema.enity.implementation.SeanceRequestResponseConverter;
import com.joshimo.cinema.enity.implementation.TicketRequestResponseConverter;
import com.joshimo.cinema.exception.TicketBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@RestController
public class OldTicketController {

    private SeanceDao seanceDao;
    private TicketDao ticketDao;
    private TicketRequestResponseConverter ticketConverter;
    private SeanceRequestResponseConverter seanceConverter;

    @Resource(name = "seanceDao")
    public void setSeanceDao(SeanceDao seanceDao) {
        this.seanceDao = seanceDao;
    }

    @Resource(name = "ticketDao")
    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Autowired
    public void setTicketConverter(TicketRequestResponseConverter ticketConverter) {
        this.ticketConverter = ticketConverter;
    }

    @Autowired
    public void setSeanceConverter(SeanceRequestResponseConverter seanceConverter) {
        this.seanceConverter = seanceConverter;
    }

    /** Ticket services */
    @GetMapping("/old/ticket/show/{id}")
    public TicketResponse findTicket(@PathVariable Long id) {
        Ticket ticket = ticketDao.findTicketById(id);
        return ticketConverter.entityToResponse(ticket);
    }

    @PostMapping("/old/ticket/book")
    public ResponseEntity bookASeat(@RequestBody TicketRequest request) {
        Ticket ticket;
        try {
            ticket = ticketConverter.requestToEntity(request);
            ticketDao.addNewTicket(ticket);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticket.getTicketId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/old/ticket/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        try {
            ticketDao.removeTicketById(id);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
    }

    /** Seances services */
    @GetMapping("/old/seance/show/all")
    public List<SeanceResponse> findSeances() {
        List<SeanceResponse> seances = new LinkedList<>();
        seanceDao.findAllSeances().forEach((seance) -> {seances.add(seanceConverter.entityToResponse(seance));});
        return seances;
    }

    @GetMapping("/old/seance/show/{id}")
    public SeanceResponse findSeanceById(@PathVariable Long id) {
        return seanceConverter.entityToResponse(seanceDao.findSeanceById(id));
    }

    @PostMapping("/old/seance/add")
    public ResponseEntity addSeance(@RequestBody SeanceRequest request) {
        Seance seance;
        try {
            seance = seanceConverter.requestToEntity(request);
            seanceDao.addNewSeance(seance);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(seance.getSeanceId()).toUri();
        return ResponseEntity.created(location).build();
    }

    /** test */
    @GetMapping("/test/{name}")
    public String hello(@PathVariable String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }
}