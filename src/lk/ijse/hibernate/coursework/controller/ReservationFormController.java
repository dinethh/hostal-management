package lk.ijse.hibernate.coursework.controller;

import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dao.custom.ReservationDAO;

/**
 * Author:Dineth Panditha
 * Date  :4/1/2023
 * Time  :10:35 AM
 * Name  :ORM-CourseWork
 */

public class ReservationFormController {
    ReservationBO reservationBO= (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
}
