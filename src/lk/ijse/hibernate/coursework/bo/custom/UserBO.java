package lk.ijse.hibernate.coursework.bo.custom;

import lk.ijse.hibernate.coursework.bo.SuperBO;
import lk.ijse.hibernate.coursework.dto.UserDTO;

import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDTO> getAllUser() throws Exception;

    boolean saveUser(UserDTO userDTO) throws Exception;

    boolean updateUser(UserDTO userDTO) throws Exception;

    boolean deleteUser(String id) throws Exception;

    UserDTO searchUser(String id) throws Exception;
    String generateNewUserID() throws Exception;
}
