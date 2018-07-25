package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {

    @Query("select s from Seance s where s.filmId = :id")
    List<Seance> findAllByFilmId(@Param("id") Long id);

}
