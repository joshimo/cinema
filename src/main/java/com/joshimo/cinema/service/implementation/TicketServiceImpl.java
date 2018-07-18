package com.joshimo.cinema.service.implementation;

import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.repository.TicketDTORepository;
import com.joshimo.cinema.repository.TicketRepository;
import com.joshimo.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketDTORepository ticketDTORepository;

    @Override
    public List<Ticket> findAllTickets() {
       return ticketRepository.findAll();
    }

    @Override
    public Ticket findTicketById(Long id) {
       return ticketRepository.findById(id).get();
    }

    @Override
    public boolean addNewTicket(Ticket ticket) {
        return false;
    }

    @Override
    public boolean removeTicketById(Long id) {
        return false;
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        return false;
    }
}
