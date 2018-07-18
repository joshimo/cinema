package com.joshimo.cinema.service.implementation;

import com.joshimo.cinema.enity.Seance;
import com.joshimo.cinema.repository.SeanceDTORepository;
import com.joshimo.cinema.repository.SeanceRepository;
import com.joshimo.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("seanceService")
public class SeanceServiceImpl implements SeanceService {

    @Autowired
    SeanceRepository seanceRepository;

    @Autowired
    SeanceDTORepository seanceDtoRepository;

    @Override
    public List<Seance> findAllSeances() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance findSeanceById(Long id) {
        return seanceRepository.findById(id).get();
    }

    @Override
    public boolean addNewSeance(Seance seance) {
        return false;
    }

    @Override
    public boolean removeSeanceById(Long id) {
        return false;
    }

    @Override
    public boolean removeSeance(Seance seance) {
        return false;
    }
}
