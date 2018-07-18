package com.joshimo.cinema.service;

import com.joshimo.cinema.enity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAllTickets();

    Ticket findTicketById(Long id);

    boolean addNewTicket(Ticket ticket);

    boolean removeTicketById(Long id);

    boolean removeTicket(Ticket ticket);
}
