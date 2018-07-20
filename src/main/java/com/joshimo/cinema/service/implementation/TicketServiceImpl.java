package com.joshimo.cinema.service.implementation;

import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.exception.NoSuchSeanceException;
import com.joshimo.cinema.exception.NoSuchTicketException;
import com.joshimo.cinema.exception.TicketBookException;
import com.joshimo.cinema.repository.SeanceRepository;
import com.joshimo.cinema.repository.TicketRepository;
import com.joshimo.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private SeanceRepository seanceRepository;

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Autowired
    public void setSeanceRepository(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public List<Ticket> findAllTickets() {
       return ticketRepository.findAll();
    }

    @Override
    public Ticket findTicketById(Long id) {
       return ticketRepository.findById(id).orElseThrow(() -> new NoSuchTicketException());
    }

    @Override
    public Ticket addNewTicket(Ticket ticket) {
        if (!checkIfFree(ticket)) {
            throw new TicketBookException("This place is already booked!");
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public void removeTicketById(Long id) {
        try {
            ticketRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchTicketException();
        }
    }

    @Override
    public void removeTicket(Ticket ticket) {
        try {
            ticketRepository.delete(ticket);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchTicketException();
        }
    }

    private boolean checkIfFree(Ticket ticket) {
        Seance seance = seanceRepository.findById(ticket.getSeanceId()).orElseThrow(() -> new NoSuchSeanceException());
        for (Ticket currentTicket: seance.getTickets()) {
            if (ticket.getRow().getRowNumber().equals(currentTicket.getRow().getRowNumber())
                    && ticket.getSeat().getSeatNumber().equals(currentTicket.getSeat().getSeatNumber())) {
                return false;
            }
        }
        return true;
    }
}