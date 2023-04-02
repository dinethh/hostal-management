package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.UserDAO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :3:15 PM
 * Name  :ORM-CourseWork
 */

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    private Session session;


    @Override
    public List<UserDTO> getAllUser() throws Exception {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) throws Exception {
        return userDAO.save(new User(userDTO.getUserId(), userDTO.getUser_name(), userDTO.getPassword()));


    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) throws Exception {
        return false;
    }
}
