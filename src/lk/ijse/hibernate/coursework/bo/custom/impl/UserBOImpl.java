package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.UserDAO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
        session = SessionFactoryConfig.getInstance().getSession();
        userDAO.setSession(session);
        List<User>allUser=userDAO.getAll();
        List<UserDTO>userDTOList=new ArrayList<>();
        for (User user:allUser
        ) {
            userDTOList.add(new UserDTO(user.getUser_id() ,user.getPassword()));
        }return userDTOList;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) throws Exception {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

//        userDAO.setSession(session);
//        String id=userDAO.save(new User(userDTO.getUser_id(),userDTO.getPassword()));
//        transaction.commit();
//        session.close();
//        return id;
        return false;

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
