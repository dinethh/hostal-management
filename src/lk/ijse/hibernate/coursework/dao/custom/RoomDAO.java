package lk.ijse.hibernate.coursework.dao.custom;

import lk.ijse.hibernate.coursework.dao.CrudDAO;
import lk.ijse.hibernate.coursework.entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room> {
    List<String> roomIds();
}
