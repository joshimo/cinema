package com.joshimo.cinema.dao.implementation;

import com.joshimo.cinema.dao.SeanceDao;
import com.joshimo.cinema.enity.Seance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service("seanceDao")
@Transactional
public class SeanceDaoImpl implements SeanceDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    public List<Seance> findAllSeances() {
        List<Seance> seanceList = new LinkedList<>();
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Seance");
        for (Object o : query.list()) {
            seanceList.add((Seance) o);
        }
        session.close();
        return seanceList;
    }

    @Override
    public Seance findSeanceById(Long id) {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Seance where id=" + id);
        Seance seance = (Seance) query.list().get(0);
        session.close();
        return seance;
    }

    @Override
    public boolean addNewSeance(Seance seance) {
        //ToDo: add an implementation
        return false;
    }

    @Override
    public boolean removeSeanceById(Long id) {
        //ToDo: add an implementation
        return false;
    }

    @Override
    public boolean removeSeance(Seance seance) {
        //ToDo: add an implementation
        return false;
    }
}