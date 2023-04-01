package lk.ijse.hibernate.coursework.dao.impl;

import lk.ijse.hibernate.coursework.dao.custom.UserDAO;
import lk.ijse.hibernate.coursework.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
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
    public List<User> getAll(){
        String sqlQuery = "FROM Customer";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public String save(User dto) {
        return (String) session.save(dto);
    }

    @Override
    public void update(User dto) throws Exception {
        session.update(dto);
    }

    @Override
    public void delete(User dto) throws Exception {
        session.delete(dto);
    }


    @Override
    public User getObject(String id) throws Exception {
        return session.get(User.class,id);
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
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


