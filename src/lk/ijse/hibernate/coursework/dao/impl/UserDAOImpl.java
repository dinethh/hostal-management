package lk.ijse.hibernate.coursework.dao.impl;

import lk.ijse.hibernate.coursework.dao.custom.UserDAO;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :3:27 PM
 * Name  :ORM-CourseWork
 */

public class UserDAOImpl implements UserDAO {
    private  Session session;


    @Override
    public boolean save(User object) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public void update(User object) {

    }

    @Override
    public User get(String s) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public List<String> geIds() throws Exception {
        return null;
    }
}
//    private Session session;
//    private static UserDAOImpl userDAOImpl;
//
//    private UserDAOImpl() {
//    }
//    public static UserDAOImpl getInstance(){
//        return null == userDAOImpl
//                ?userDAOImpl =new UserDAOImpl()
//                :userDAOImpl;
//    }
//    public void setSession(Session session) {
//        this.session = session;
//    }
//
//    //save
//    @Override
//    public String save(User user){
//        return (String) session.save(user);
//    }
//
//    //Update
//    @Override
//    public void update(User user){
//        session.update(user);
//    }


