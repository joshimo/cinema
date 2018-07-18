package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.enity.TicketDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDTORepository extends JpaRepository<TicketDTO, Long> {
}
