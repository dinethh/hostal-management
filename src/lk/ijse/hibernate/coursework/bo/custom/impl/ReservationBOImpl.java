package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.ReservationDAO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;

import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :9:52 AM
 * Name  :ORM-CourseWork
 */

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        return null;
    }
}
