package com.joshimo.cinema.dao;

import com.joshimo.cinema.enity.Ticket;

import java.util.List;

@Deprecated
public interface TicketDao {

    List<Ticket> findAllTickets();

    Ticket findTicketById(Long id);

    boolean addNewTicket(Ticket ticket);

    boolean removeTicketById(Long id);

    boolean removeTicket(Ticket ticket);
}
