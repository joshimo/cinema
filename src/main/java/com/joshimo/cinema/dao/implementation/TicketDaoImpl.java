package com.joshimo.cinema.dao.implementation;

import com.joshimo.cinema.dao.TicketDao;
import com.joshimo.cinema.enities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        //ToDo: add an implementation
        return null;
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
        //ToDo: add an implementation
        return false;
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        //ToDo: add an implementation
        return false;
    }
}
