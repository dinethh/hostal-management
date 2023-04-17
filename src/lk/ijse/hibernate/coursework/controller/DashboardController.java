package lk.ijse.hibernate.coursework.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * Author:Dineth Panditha
 * Date  :4/17/2023
 * Time  :4:40 PM
 * Name  :ORM-CourseWork
 */

public class DashboardController implements Initializable {

    public Label lblStuCount;
    public Label lblRoomCount;
    public Label lblReservedCount;
    private Transaction transaction = null;
    private Session session;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStudentCount();
        setRoomCount();
        setReservedCount();
    }

    private void setStudentCount() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String SQL_QUERY = "SELECT COUNT(*) FROM Student student";
        Query query = session.createQuery(SQL_QUERY);

        for (Iterator it = query.iterate(); it.hasNext(); ) {
            long row = (Long) it.next();
            lblStuCount.setText(String.valueOf(row));
        }
        session.getTransaction().commit();
        session.close();
    }

    private void setRoomCount() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String SQL_QUERY = "SELECT COUNT(*) FROM Room room";
        Query query = session.createQuery(SQL_QUERY);

        for (Iterator it = query.iterate(); it.hasNext(); ) {
            long row = (Long) it.next();
            lblRoomCount.setText(String.valueOf(row));
        }
        session.getTransaction().commit();
        session.close();
    }

    private void setReservedCount() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String SQL_QUERY = "SELECT COUNT(*) FROM Reservation";
        Query query = session.createQuery(SQL_QUERY);

        for (Iterator it = query.iterate(); it.hasNext(); ) {
            long row = (Long) it.next();
            lblReservedCount.setText(String.valueOf(row));
        }
        session.getTransaction().commit();
        session.close();
    }
}
