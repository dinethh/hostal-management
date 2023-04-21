package lk.ijse.hibernate.coursework.dao.impl;

import lk.ijse.hibernate.coursework.dao.custom.ReservationDAO;
import lk.ijse.hibernate.coursework.entity.Reservation;
import lk.ijse.hibernate.coursework.entity.Student;
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
    Reservation reservation;
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

        reservation=new Reservation();
        reservation.setResId(id);
        try {
            session.delete(reservation);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String generateNewID() throws Exception {
        String sql="FROM Reservation ORDER BY id DESC";
        Reservation reservation= (Reservation) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();
        if (reservation!=null){
            String lastId=reservation.getResId();
            int newReservationId=Integer.parseInt(lastId.replace("STU-",""))+1;
            System.out.println(newReservationId);
            return String.format("RES-%03d",newReservationId);
        }
        return "RES-001";
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
