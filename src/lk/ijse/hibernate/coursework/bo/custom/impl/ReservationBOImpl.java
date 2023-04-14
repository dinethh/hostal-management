package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.ReservationDAO;
import lk.ijse.hibernate.coursework.dao.custom.RoomDAO;
import lk.ijse.hibernate.coursework.dao.custom.StudentDAO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;
import lk.ijse.hibernate.coursework.entity.Reservation;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :9:52 AM
 * Name  :ORM-CourseWork
 */

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    private Session session;

    @Override
    public List<String> getStudentIds() {
        try{
            session= SessionFactoryConfiguration.getInstance ().getSession ();
            studentDAO.setSession (session);
            return studentDAO.getStIds();

        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public List<String> getRoomIds() {
        try{
            session= SessionFactoryConfiguration.getInstance ().getSession ();
            roomDAO.setSession (session);
            return roomDAO.roomIds ();
        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public StudentDTO getStudent(String id) {
        return null;
    }

    @Override
    public RoomDTO getRoom(String id) {
        return null;
    }

    @Override
    public boolean saveReservation(ReservationDTO dto) {
       return reservationDAO.save(new Reservation(
               dto.getResId(),
               dto.getDate(),
               dto.getStatus(),
               dto.getStudent_id(),
               dto.getRoom_type_id()
       ));
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        return false;
    }

    @Override
    public boolean deleteReservation(ReservationDTO dto) {
        return false;
    }
}
