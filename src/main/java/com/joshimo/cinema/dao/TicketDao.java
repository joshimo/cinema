package com.joshimo.cinema.dao;

import com.joshimo.cinema.enities.Ticket;

import java.util.List;

public interface TicketDao {

    List<Ticket> findAllTickets();

    Ticket findTicketById(Long id);

    boolean addNewTicket(Ticket ticket);

    boolean removeTicketById(Long id);

    boolean removeTicket(Ticket ticket);
}
