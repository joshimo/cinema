package com.joshimo.cinema.service;

import com.joshimo.cinema.dao.SeanceDao;
import com.joshimo.cinema.dao.TicketDao;
import com.joshimo.cinema.enities.Seance;
import com.joshimo.cinema.enities.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TicketController {

    private Ticket ticketMock;

    @Resource(name = "seanceDao")
    private SeanceDao seanceDao;

    @Resource(name = "ticketDao")
    private TicketDao ticketDao;

    {
        ticketMock = new Ticket();
        ticketMock.setTicketId(System.currentTimeMillis());
        ticketMock.setCost(100.0);
        ticketMock.setReserved(true);
    }

    @GetMapping("/service/book")
    public Ticket bookASeat(Long seanceId, Integer rowNumber, Integer seatNumber) {
        //ToDo: mock shall be replaced with real ticket entity recieved from DB with Hibernate
        ticketMock.setSeanceId(seanceId);
        ticketMock.setRowNumber(rowNumber);
        ticketMock.setSeatNumber(seatNumber);
        return ticketMock;
    }

    @GetMapping("/service/showAllSeances")
    public List<Seance> findSeances() {
        return seanceDao.findAllSeances();
    }

    @GetMapping("/service/showSeance/{id}")
    public Seance findSeanceById(@PathVariable Long id) {
        return seanceDao.findSeanceById(id);
    }

    @GetMapping("/service/book/{seanceId}/{rowNum}/{seatNum}")
    public String book(@PathVariable Long seanceId,
                       @PathVariable Integer rowNum,
                       @PathVariable Integer seatNum) {
        Ticket ticket = new Ticket();
        ticket.setCost(0d);
        ticket.setSeanceId(seanceId);
        ticket.setRowNumber(rowNum);
        ticket.setSeatNumber(seatNum);
        if (ticketDao.addNewTicket(ticket))
            return "Success! You has been booked a ticket!";
        else
            return "Error! Your ticket has not been booked!";
    }

    @GetMapping("/service/hello/{name}")
    public String hello(@PathVariable String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

}
