package com.joshimo.cinema.service.implementation;

import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.exception.NoSuchSeanceException;
import com.joshimo.cinema.repository.SeanceRepository;
import com.joshimo.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("seanceService")
public class SeanceServiceImpl implements SeanceService {

    private SeanceRepository seanceRepository;

    @Autowired
    public void setSeanceRepository(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public List<Seance> findAllSeances() {
        return seanceRepository.findAll();
    }

    @Override
    public List<Seance> findAllByFilmId(Long id) {
        return seanceRepository.findAllByFilmId(id);
    }

    @Override
    public Seance findSeanceById(Long id) {
        return seanceRepository.findById(id).orElseThrow(() -> new NoSuchSeanceException());
    }

    @Override
    public Seance addNewSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public void removeSeanceById(Long id) {
        try {
            seanceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchSeanceException();
        }
    }

    @Override
    public void removeSeance(Seance seance) {
        try {
            seanceRepository.delete(seance);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchSeanceException();
        }
    }
}