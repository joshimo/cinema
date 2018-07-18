package com.joshimo.cinema.controller;

import com.joshimo.cinema.dao.SeanceDao;
import com.joshimo.cinema.dao.TicketDao;
import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.exception.TicketBookException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class TicketController {

    @Resource(name = "seanceDao")
    private SeanceDao seanceDao;

    @Resource(name = "ticketDao")
    private TicketDao ticketDao;

    /** Ticket services */
    @GetMapping("/ticket/show/{id}")
    public Ticket findTicket(@PathVariable Long id) {
      return ticketDao.findTicketById(id);
    }

    @PostMapping("/ticket/book")
    public ResponseEntity bookASeat(@RequestBody Ticket ticket) {
        try {
            ticketDao.addNewTicket(ticket);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticket.getTicketId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/ticket/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        try {
            ticketDao.removeTicketById(id);
        }
        catch (Exception e) {
            throw new TicketBookException(e.getMessage());
        }
    }

    /** Seances services */
    @GetMapping("/seance/show/all")
    public List<Seance> findSeances() {
        return seanceDao.findAllSeances();
    }

    @GetMapping("/seance/show/{id}")
    public Seance findSeanceById(@PathVariable Long id) {
        return seanceDao.findSeanceById(id);
    }

    /** test */
    @GetMapping("/test/{name}")
    public String hello(@PathVariable String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }
}