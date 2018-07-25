package com.joshimo.cinema.enity.implementation;

import com.joshimo.cinema.enity.EntityRequestResponseConverter;
import com.joshimo.cinema.enity.Row;
import com.joshimo.cinema.enity.Seat;
import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.enity.dto.TicketRequest;
import com.joshimo.cinema.enity.dto.TicketResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ticketRequestResponseConverter")
public class TicketRequestResponseConverter implements EntityRequestResponseConverter<TicketRequest, Ticket, TicketResponse> {

    @Override
    public Ticket requestToEntity(TicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setSeanceId(request.getSeanceId());
        ticket.setRow(new Row(request.getRowNumber()));
        ticket.setSeat(new Seat(request.getSeatNumber()));
        return ticket;
    }

    @Override
    public TicketResponse entityToResponse(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setTicketId(ticket.getTicketId());
        response.setUserId(ticket.getUser().getId());
        response.setUserName(ticket.getUser().getName());
        response.setSchedule("shall be added");
        response.setFilmName("shall be added");
        response.setCost(ticket.getRow().getCost());
        response.setRowNumber(ticket.getRow().getRowNumber());
        response.setSeatNumber(ticket.getSeat().getSeatNumber());
        return response;
    }
}
