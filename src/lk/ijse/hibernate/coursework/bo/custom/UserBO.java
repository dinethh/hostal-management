package lk.ijse.hibernate.coursework.bo.custom;

import lk.ijse.hibernate.coursework.bo.SuperBO;
import lk.ijse.hibernate.coursework.dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> getAllUser() throws Exception;

    boolean saveUser(UserDTO userDTO) throws Exception;

    boolean updateUser(UserDTO userDTO) throws Exception;

    boolean deleteUser(UserDTO userDTO) throws Exception;
}
