package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.enity.dto.TicketRequest;
import com.joshimo.cinema.enity.dto.TicketResponse;
import com.joshimo.cinema.enity.implementation.TicketRequestResponseConverter;
import com.joshimo.cinema.service.TicketService;
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
public class TicketController {

    private TicketService ticketService;
    private TicketRequestResponseConverter ticketConverter;

    @Resource(name = "ticketService")
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setTicketConverter(TicketRequestResponseConverter ticketConverter) {
        this.ticketConverter = ticketConverter;
    }

    /** Ticket services */

    @GetMapping("/ticket/show/all")
    public List<TicketResponse> findAllTickets() {
        List<TicketResponse> tickets = new LinkedList<>();
        ticketService.findAllTickets().forEach((ticket) -> {
            tickets.add(ticketConverter.entityToResponse(ticket));
        });
        return tickets;
    }

    @GetMapping("/ticket/show/{id}")
    public TicketResponse findTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        return ticketConverter.entityToResponse(ticket);
    }

    @PostMapping("/ticket/book")
    public ResponseEntity bookASeat(@Valid @RequestBody TicketRequest request) {
        Ticket ticket = ticketConverter.requestToEntity(request);
        Ticket booked = ticketService.addNewTicket(ticket);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(booked.getTicketId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/ticket/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        ticketService.removeTicketById(id);
    }
}