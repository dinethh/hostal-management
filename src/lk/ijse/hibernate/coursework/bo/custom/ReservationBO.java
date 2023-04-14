package lk.ijse.hibernate.coursework.bo.custom;

import lk.ijse.hibernate.coursework.bo.SuperBO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<String> getStudentIds();
    List<String> getRoomIds();
    StudentDTO getStudent(String id);
    RoomDTO getRoom(String id);

    boolean saveReservation(ReservationDTO dto);

    boolean updateRoom(RoomDTO dto);

    boolean deleteReservation(ReservationDTO dto);

//    RoomDTO searchRoom(String id) throws Exception;
}
