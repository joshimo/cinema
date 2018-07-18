package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
