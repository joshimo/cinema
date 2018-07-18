package com.joshimo.cinema.service;

import com.joshimo.cinema.enity.Seance;

import java.util.List;

public interface SeanceService {

    List<Seance> findAllSeances();

    Seance findSeanceById(Long id);

    boolean addNewSeance(Seance seance);

    boolean removeSeanceById(Long id);

    boolean removeSeance(Seance seance);
}
