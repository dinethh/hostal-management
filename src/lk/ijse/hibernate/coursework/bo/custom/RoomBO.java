package lk.ijse.hibernate.coursework.bo.custom;

import lk.ijse.hibernate.coursework.bo.SuperBO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO> getAllRoom() throws Exception;

    boolean saveRoom(RoomDTO roomDTO) throws Exception;

    boolean updateRoom(RoomDTO roomDTO) throws Exception;

    boolean deleteRoom(String id) throws Exception;

    RoomDTO searchRoom(String id) throws Exception;
}
