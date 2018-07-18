package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
