package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
