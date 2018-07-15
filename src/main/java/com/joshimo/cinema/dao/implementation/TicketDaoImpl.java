package com.joshimo.cinema.dao.implementation;

import com.joshimo.cinema.dao.TicketDao;
import com.joshimo.cinema.enity.Ticket;
import com.joshimo.cinema.exception.TicketBookException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service("ticketDao")
@Transactional
public class TicketDaoImpl implements TicketDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    public List<Ticket> findAllTickets() {
        //ToDo: add an implementation
        return null;
    }

    @Override
    public Ticket findTicketById(Long id) {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Ticket where id=" + id);
        Ticket ticket = (Ticket) query.list().get(0);
        session.close();
        return ticket;
    }

    @Override
    public boolean addNewTicket(Ticket ticket) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(ticket);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean removeTicketById(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Ticket where id=" + id);
        Ticket ticket = (Ticket) query.list().get(0);
        session.delete(ticket);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(ticket);
        session.getTransaction().commit();
        return true;
    }
}
