package lk.ijse.hibernate.coursework.dao.impl;

import lk.ijse.hibernate.coursework.dao.custom.ReservationDAO;
import lk.ijse.hibernate.coursework.entity.Reservation;
import lk.ijse.hibernate.coursework.entity.Room;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :9:57 AM
 * Name  :ORM-CourseWork
 */

public class ReservationDAOImpl implements ReservationDAO {
    private Transaction transaction = null;
    private Session session;

    @Override
    public List<Reservation> getAll() {

        List<Reservation> reservation = null;
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        reservation = session.createQuery("FROM Reservation ").list();
        transaction.commit();
        return reservation;


    }

    @Override
    public boolean save(Reservation entity) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Reservation entity) {
        session.update(entity);
        return true;


    }

    @Override
    public boolean delete(String id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Reservation reservation = null;
        reservation = session.get(Reservation.class, id);
        session.delete(reservation);
        transaction.commit();
        return true;
       // return false;
    }

    @Override
    public Reservation search(String id) {

        Reservation reservation = null;
        reservation = session.get(Reservation.class, id);
        return reservation;

    }

    @Override
    public Reservation getObject(String id) {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
