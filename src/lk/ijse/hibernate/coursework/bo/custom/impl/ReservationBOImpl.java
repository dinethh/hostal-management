package lk.ijse.hibernate.coursework.bo.custom.impl;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.ReservationDAO;
import lk.ijse.hibernate.coursework.dao.custom.RoomDAO;
import lk.ijse.hibernate.coursework.dao.custom.StudentDAO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;
import lk.ijse.hibernate.coursework.entity.Reservation;
import lk.ijse.hibernate.coursework.entity.Room;
import lk.ijse.hibernate.coursework.entity.Student;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :9:52 AM
 * Name  :ORM-CourseWork
 */

public class ReservationBOImpl implements ReservationBO {
    private final Transaction transaction = null;
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private Session session;

    @Override
    public List<String> getStudentIds() {
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            studentDAO.setSession(session);
            return studentDAO.getStIds();

        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    @Override
    public List<String> getRoomIds() {
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            roomDAO.setSession(session);
            return roomDAO.roomIds();
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

//    @Override
//    public List<String> getRoomTypes() {
//        try {
//            session = SessionFactoryConfiguration.getInstance().getSession();
//            roomDAO.setSession(session);
//            return roomDAO.roomTypes();
//        } catch (Exception e) {
//            session.close();
//            return null;
//        }
//    }


    @Override
    public StudentDTO getStudent(String id) {

        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        studentDAO.setSession(session);
        try {
            Student st = studentDAO.search(id);
            session.close();
            return new StudentDTO(
                    st.getStudent_id(),
                    st.getName(),
                    st.getAddress(),
                    st.getContact_no(),
                    st.getDob(),
                    st.getGender()
            );

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public RoomDTO getRoom(String id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        roomDAO.setSession(session);
        try {
            Room r = roomDAO.search(id);
            session.close();
            return new RoomDTO(
                    r.getRoom_type_id(),
                    r.getType(),
                    r.getKey_money(),
                    r.getQty()
            );

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public List<ReservationDTO> getAllReservation() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();

        roomDAO.setSession(session);
        List<Reservation> list = reservationDAO.getAll();
        List<ReservationDTO> resList = new ArrayList<>();

        for (Reservation res : list) {
            resList.add(new ReservationDTO(
                    res.getResId(),
                    res.getDate(),
                    new StudentDTO(
                            res.getStudent().getStudent_id(),
                            res.getStudent().getName(),
                            res.getStudent().getAddress(),
                            res.getStudent().getContact_no(),
                            res.getStudent().getDob(),
                            res.getStudent().getGender()
                    ),
                    new RoomDTO(
                            res.getRoom().getRoom_type_id(),
                            res.getRoom().getType(),
                            res.getRoom().getKey_money(),
                            res.getRoom().getQty()
                    ),
                    res.getStatus()
            ));
        }

        return resList;

    }


    @Override
    public boolean saveReservation(ReservationDTO dto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.save(
                    new Reservation(
                            dto.getResId(),
                            dto.getDate(),
                            new Student(
                                    dto.getStudentDTO().getStudent_id(),
                                    dto.getStudentDTO().getName(),
                                    dto.getStudentDTO().getAddress(),
                                    dto.getStudentDTO().getContact_no(),
                                    dto.getStudentDTO().getDob(),
                                    dto.getStudentDTO().getGender()
                            ),
                            new Room(
                                    dto.getRoomDTO().getRoom_type_id(),
                                    dto.getRoomDTO().getType(),
                                    dto.getRoomDTO().getKey_money(),
                                    dto.getRoomDTO().getQty()
                            ),
                            dto.getStatus()
                    ));
            transaction.commit();
            session.close();
            return true;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomDAO.setSession(session);
            roomDAO.update(new Room(
                    dto.getRoom_type_id(),
                    dto.getType(),
                    dto.getKey_money(),
                    dto.getQty()
            ));

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        }
        return false;

    }

    @Override
    public boolean updateReservation(ReservationDTO dto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.update(
                    new Reservation(
                            dto.getResId(),
                            dto.getDate(),
                            new Student(
                                    dto.getStudentDTO().getStudent_id(),
                                    dto.getStudentDTO().getName(),
                                    dto.getStudentDTO().getAddress(),
                                    dto.getStudentDTO().getContact_no(),
                                    dto.getStudentDTO().getDob(),
                                    dto.getStudentDTO().getGender()
                            ),
                            new Room(
                                    dto.getRoomDTO().getRoom_type_id(),
                                    dto.getRoomDTO().getType(),
                                    dto.getRoomDTO().getKey_money(),
                                    dto.getRoomDTO().getQty()
                            ),
                            dto.getStatus()
                    ));
            transaction.commit();
            session.close();
            return true;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public List<ReservationDTO> loadAllRes() {
        return null;
    }

    @Override
    public boolean deleteReservation(ReservationDTO dto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        System.out.println("session "+session);
        Transaction transaction = session.beginTransaction();
        try {
            reservationDAO.setSession(session);
            /*reservationDAO.delete(
                    String.valueOf(new Reservation(
                            dto.getResId(),
                            dto.getDate(),
                            new Student(
                                    dto.getStudentDTO().getStudent_id(),
                                    dto.getStudentDTO().getName(),
                                    dto.getStudentDTO().getAddress(),
                                    dto.getStudentDTO().getContact_no(),
                                    dto.getStudentDTO().getDob(),
                                    dto.getStudentDTO().getGender()
                            ),
                            new Room(
                                    dto.getRoomDTO().getRoom_type_id(),
                                    dto.getRoomDTO().getType(),
                                    dto.getRoomDTO().getKey_money(),
                                    dto.getRoomDTO().getQty()
                            ),
                            dto.getStatus()
                    ))
            );*/

            reservationDAO.delete(dto.getResId());
            transaction.commit();

            return true;
        } catch (Exception e) {
            System.out.println(" Exception "+e);
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public ReservationDTO searchReservation(String id) throws Exception {
        Reservation reservation = reservationDAO.search(id);
        return new ReservationDTO(
                reservation.getResId(),
                reservation.getDate(),
                reservation.getStudent(),
                reservation.getRoom(),
                reservation.getStatus());
    }


}

