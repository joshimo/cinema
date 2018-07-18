package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.SeanceDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceDTORepository extends JpaRepository<SeanceDTO, Long> {
}
