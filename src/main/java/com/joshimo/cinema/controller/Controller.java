package com.joshimo.cinema.controller;

import com.joshimo.cinema.dao.SeanceDao;
import com.joshimo.cinema.dao.TicketDao;
import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.enity.dto.TicketRequest;
import com.joshimo.cinema.enity.dto.TicketResponse;
import com.joshimo.cinema.enity.implementation.SeanceRequestResponseConverter;
import com.joshimo.cinema.enity.implementation.TicketRequestResponseConverter;
import com.joshimo.cinema.exception.TicketBookException;
import com.joshimo.cinema.service.SeanceService;
import com.joshimo.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class Controller {

    @Resource(name = "seanceService")
    private SeanceService seanceDao;

    @Resource(name = "ticketService")
    private TicketService ticketDao;

    @Autowired
    private TicketRequestResponseConverter ticketConverter;

    @Autowired
    private SeanceRequestResponseConverter seanceConverter;

    /** Ticket services */
    @GetMapping("/d/ticket/show/{id}")
    public TicketResponse findTicket(@PathVariable Long id) {
        Ticket ticket = ticketDao.findTicketById(id);
        return ticketConverter.entityToResponse(ticket);
    }

    @PostMapping("/d/ticket/book")
    public ResponseEntity bookASeat(@RequestBody TicketRequest ticketRequest) {
        Ticket ticket;
        try {
            ticket = ticketConverter.requestToEntity(ticketRequest);
            ticketDao.addNewTicket(ticket);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticket.getTicketId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/d/ticket/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        try {
            ticketDao.removeTicketById(id);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
    }

    /** Seances services */
    @GetMapping("/d/seance/show/all")
    public List<Seance> findSeances() {
        return seanceDao.findAllSeances();
    }

    @GetMapping("/d/seance/show/{id}")
    public Seance findSeanceById(@PathVariable Long id) {
        return seanceDao.findSeanceById(id);
    }
}
