package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.RoomBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.SuperDAO;
import lk.ijse.hibernate.coursework.dao.custom.RoomDAO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.entity.Room;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :9:53 AM
 * Name  :ORM-CourseWork
 */

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    private Session session;

    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        List<RoomDTO> allRooms = new ArrayList<>();
        List<Room> all = roomDAO.getAll();
        for (Room room : all){
            allRooms.add(new RoomDTO(
                    room.getRoom_type_id(),
                    room.getType(),
                    room.getKey_money(),
                    room.getQty()
            ));
        }
        return allRooms;
    }

    @Override
    public boolean saveRoom(RoomDTO roomDTO) throws Exception {
        return roomDAO.save(new Room(
                roomDTO.getRoom_type_id(),
                roomDTO.getType(),
                roomDTO.getKey_money(),
                roomDTO.getQty()));
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(new Room(
                roomDTO.getRoom_type_id(),
                roomDTO.getType(),
                roomDTO.getKey_money(),
                roomDTO.getQty()));
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomDAO.delete(id);
    }

    @Override
    public RoomDTO searchRoom(String id) throws Exception {
        Room room = roomDAO.search(id);
        return new RoomDTO(
                room.getRoom_type_id(),
                room.getType(),
                room.getKey_money(),
                room.getQty());
    }
}
