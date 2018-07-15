package com.joshimo.cinema.dao;

import com.joshimo.cinema.enity.Seance;

import java.util.List;

public interface SeanceDao {

    List<Seance> findAllSeances();

    Seance findSeanceById(Long id);

    boolean addNewSeance(Seance seance);

    boolean removeSeanceById(Long id);

    boolean removeSeance(Seance seance);
}
