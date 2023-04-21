package lk.ijse.hibernate.coursework.dao.impl;

import lk.ijse.hibernate.coursework.dao.custom.UserDAO;
import lk.ijse.hibernate.coursework.entity.Student;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :3:27 PM
 * Name  :ORM-CourseWork
 */

public class UserDAOImpl implements UserDAO {
   private Transaction transaction = null;
    private Session session;

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User object) {
        session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            session.close();
//        if (transaction !=null){
//            transaction.rollback();
//        }
        return true;
    }

    @Override
    public boolean update(User entity) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

//        if (transaction !=null){
//            transaction.rollback();
//        }
        return true;

    }

    @Override
    public boolean delete(String id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        User user = null;
        user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
//        if (transaction !=null){
//            transaction.rollback();
//        }
        return true;

    }

    @Override
    public String generateNewID() throws Exception {
        String sql="FROM User ORDER BY id DESC";
        User user = (User) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();
        if (user!=null){
            String lastId= user.getUserId();
            int newUserId=Integer.parseInt(lastId.replace("USER-",""))+1;
            return String.format("USER-%03d",newUserId);
        }
        return "USER-001";
    }

    @Override
    public User search(String id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        User user = null;
        user = session.get(User.class, id);
        transaction.commit();
        return user;
    }

    @Override
    public User getObject(String id) {
        return null;
    }


    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}



