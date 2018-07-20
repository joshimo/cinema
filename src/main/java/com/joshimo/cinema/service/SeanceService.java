package com.joshimo.cinema.service;

import com.joshimo.cinema.enity.Seance;

import java.util.List;

public interface SeanceService {

    List<Seance> findAllSeances();

    Seance findSeanceById(Long id);

    Seance addNewSeance(Seance seance);

    void removeSeanceById(Long id);

    void removeSeance(Seance seance);
}
