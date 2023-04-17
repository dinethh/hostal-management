package lk.ijse.hibernate.coursework.bo.custom;

import lk.ijse.hibernate.coursework.bo.SuperBO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<String> getStudentIds();

    List<String> getRoomIds();

    //    List<String> getRoomTypes();
    StudentDTO getStudent(String id);

    RoomDTO getRoom(String id);

    List<ReservationDTO> getAllReservation() throws Exception;

    boolean saveReservation(ReservationDTO dto);

    boolean updateRoom(RoomDTO dto);

    boolean updateReservation(ReservationDTO dto);

    ReservationDTO searchReservation(String id) throws Exception;

    List<ReservationDTO> loadAllRes();

    boolean deleteReservation(ReservationDTO dto);
}
