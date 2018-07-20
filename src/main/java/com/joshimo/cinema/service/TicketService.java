package com.joshimo.cinema.service;

import com.joshimo.cinema.enity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAllTickets();

    Ticket findTicketById(Long id);

    Ticket addNewTicket(Ticket ticket);

    void removeTicketById(Long id);

    void removeTicket(Ticket ticket);
}
