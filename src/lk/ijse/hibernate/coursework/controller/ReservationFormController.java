package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Author:Dineth Panditha
 * Date  :4/1/2023
 * Time  :10:35 AM
 * Name  :ORM-CourseWork
 */

public class ReservationFormController implements Initializable {
    public JFXComboBox cmbStatus;
    public JFXTextField txtResID;
    public JFXComboBox cmbRoomTypeID;
    public JFXComboBox cmbStudentID;
    public TableColumn colQTYrec;
    public JFXTextField txtQtyfromREC;
    public JFXTextField txtQty;
    public TableView tblReservation;
    public TableColumn colResID;
    public TableColumn colDate;
    public TableColumn colStudentID;
    public TableColumn colRoomType;
    public TableColumn colStatus;
    public Label lblDate;


    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    private void setDataTable() {
        tblReservation.getItems().clear();
        try {
            for (ReservationDTO r : reservationBO.getAllReservation()) {
                tblReservation.getItems().add(new ReservationDTO(
                        r.getResId(),
                        r.getDate(),
                        r.getStudentDTO(),
                        r.getRoomDTO(),
                        r.getStatus()
                ));
                System.out.println("===================================");
                System.out.println(r.getResId()+" "
                        +r.getDate()+" "+r.getStudentDTO()+" "+r.getRoomDTO());
                System.out.println("===================================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void SavaOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = getStudnetDetail();
        RoomDTO roomDTO = getRoomDetail();
        String resID = txtResID.getText();
        String status = cmbStatus.getValue().toString();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());


        try {
            boolean isSaveReservation = reservationBO.saveReservation(
                    new ReservationDTO(
                            resID,
                            sqlDate,
                            studentDTO,
                            roomDTO,
                            status
                    ));


            if (isSaveReservation) {
                RoomDTO room = getRoomDetail();
                room.setQty(room.getQty() - 1);
                reservationBO.updateRoom(room);
                new Alert(Alert.AlertType.CONFIRMATION, "QTY is Updated").show();
                setDataTable();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void UpdateOnAction(ActionEvent actionEvent) {

        String status = cmbStatus.getValue().toString();
        String resId = txtResID.getText();
        StudentDTO studentDTO = getStudnetDetail();
        RoomDTO roomDTO = getRoomDetail();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try {
            if (reservationBO.updateReservation(
                    new ReservationDTO(
                            resId,
                            sqlDate,
                            studentDTO,
                            roomDTO,
                            status))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                setDataTable();
                //  Clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {

        String status = cmbStatus.getValue().toString();
        String resId = txtResID.getText();
        StudentDTO studentDTO = getStudnetDetail();
        RoomDTO roomDTO = getRoomDetail();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try{
            boolean isDelete=reservationBO.deleteReservation (
                    new ReservationDTO (
                            resId,
                            sqlDate,
                            studentDTO,
                            roomDTO,
                            status
                    ));
            if (isDelete){
                RoomDTO room=getRoomDetail ();
                room.setQty (room.getQty ()+1);
                reservationBO.updateRoom (room);
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation is Removed").show();
                setDataTable();
            }
        }catch (Exception e){
            e.printStackTrace ();
        }


    }

    public void SearchOnAction(ActionEvent actionEvent) {
        ReservationDTO reservation;
        try {
            reservation = reservationBO.searchReservation(txtResID.getText());
            if (reservation != null) {
                fillData(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillData(ReservationDTO reservation) {
        txtResID.setText(reservation.getResId());
        cmbStudentID.setValue(reservation.getStudentDTO().getStudent_id());
        cmbRoomTypeID.setValue(reservation.getRoomDTO().getRoom_type_id());
        cmbStatus.setValue(reservation.getStatus());
        lblDate.setText(String.valueOf(reservation.getDate()));
    }

    public void setIds() {
        List<String> stIds = reservationBO.getStudentIds();
        ObservableList student = FXCollections.observableArrayList(stIds);
        cmbStudentID.setItems(student);

        List<String> roomIds = reservationBO.getRoomIds();
        ObservableList room = FXCollections.observableArrayList(roomIds);
        cmbRoomTypeID.setItems(room);
//        List<String> roomType = reservationBO.getRoomTypes();
//        ObservableList type = FXCollections.observableArrayList(roomType);
//        cmbRoomTypeID.setItems(type);

    }

    public void setStatus() {
        ObservableList<String> data = FXCollections.observableArrayList("PAID", "UNPAID");
        cmbStatus.setItems(data);
    }

    public StudentDTO getStudnetDetail() {
        String stId = cmbStudentID.getValue().toString();
        return reservationBO.getStudent(stId);
    }

    public RoomDTO getRoomDetail() {
        String roomId = cmbRoomTypeID.getValue().toString();
        return reservationBO.getRoom(roomId);
//        String roomType = cmbRoomTypeID.getValue().toString();
//        return reservationBO.getRoom(roomType);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIds();
        setStatus();
        setDataTable();

        colResID.setCellValueFactory(new PropertyValueFactory<>("resId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentDTO.getStudent_id()"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

}

