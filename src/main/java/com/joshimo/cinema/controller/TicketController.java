package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.enity.dto.TicketRequest;
import com.joshimo.cinema.enity.dto.TicketResponse;
import com.joshimo.cinema.enity.implementation.TicketRequestResponseConverter;
import com.joshimo.cinema.service.TicketService;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;
    private TicketRequestResponseConverter ticketConverter;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setTicketConverter(TicketRequestResponseConverter ticketConverter) {
        this.ticketConverter = ticketConverter;
    }


    /** Ticket services */

    @GetMapping("/show/all")
    public List<TicketResponse> findAllTickets() {
        List<TicketResponse> tickets = new LinkedList<>();
        ticketService.findAllTickets().forEach((ticket) -> {
            tickets.add(ticketConverter.entityToResponse(ticket));
        });
        return tickets;
    }

    @GetMapping("/show/{id}")
    public Resource<TicketResponse> findTicket(HttpServletRequest request, @PathVariable Long id) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user);
        Ticket ticket = ticketService.findTicketById(id);
        Long seanceId = ticket.getSeanceId();
        TicketResponse ticketResponse = ticketConverter.entityToResponse(ticket);
        Resource<TicketResponse> resource = new Resource<>(ticketResponse);
        ControllerLinkBuilder linkToSeance = linkTo(methodOn(SeanceController.class).findSeanceById(seanceId));
        resource.add(linkToSeance.withRel("seance"));
        return resource;
    }

    @PostMapping("/book")
    public ResponseEntity bookASeat(@Valid @RequestBody TicketRequest request, HttpServletRequest req) {
        Ticket ticket = ticketConverter.requestToEntity(request);
        ticket.setUser((User) req.getSession().getAttribute("user"));
        Ticket booked = ticketService.addNewTicket(ticket);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(booked.getTicketId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        ticketService.removeTicketById(id);
    }
}