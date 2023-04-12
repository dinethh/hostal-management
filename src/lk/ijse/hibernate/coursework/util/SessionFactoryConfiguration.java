package lk.ijse.hibernate.coursework.util;

import lk.ijse.hibernate.coursework.entity.Reservation;
import lk.ijse.hibernate.coursework.entity.Room;
import lk.ijse.hibernate.coursework.entity.Student;
import lk.ijse.hibernate.coursework.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author:Dineth Panditha
 * Date  :4/2/2023
 * Time  :4:40 PM
 * Name  :ORM-CourseWork
 */

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        sessionFactory = new Configuration().mergeProperties(Utility.getProperties())

                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .buildSessionFactory();

    }

    public static SessionFactoryConfiguration getInstance() {
        return (null == factoryConfiguration) ? factoryConfiguration = new SessionFactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
