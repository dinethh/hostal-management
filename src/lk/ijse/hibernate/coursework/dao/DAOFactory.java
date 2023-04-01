package lk.ijse.hibernate.coursework.dao;

import lk.ijse.hibernate.coursework.dao.impl.UserDAOImpl;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :2:08 PM
 * Name  :ORM-CourseWork
 */

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public lk.ijse.hibernate.coursework.dao.SuperDAO getDAO(DAOTypes types) {

        switch (types) {
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        USER
    }
}
