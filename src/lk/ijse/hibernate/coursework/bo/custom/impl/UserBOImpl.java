package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.UserDAO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.entity.User;
import org.hibernate.Session;

import java.util.ArrayList;

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
    public ArrayList<UserDTO> getAllUser() throws Exception {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) throws Exception {
        return userDAO.save(new User(userDTO.getUserId(), userDTO.getUser_name(), userDTO.getPassword()));

    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        return userDAO.update(new User(
                userDTO.getUserId(),
                userDTO.getUser_name(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public UserDTO searchUser(String id) throws Exception {
        User user = userDAO.search(id);
        return new UserDTO(
                user.getUserId(),
                user.getUser_name(),
                user.getPassword());
    }


}
