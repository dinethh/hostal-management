package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;

import java.net.URL;
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
    public JFXTextField txtDate;


    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public void SavaOnAction(ActionEvent actionEvent) {
        String recID = txtResID.getId();
        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String status = String.valueOf(cmbStatus.getValue());
        String stuID = String.valueOf(cmbStudentID.getValue());
        String roomID = String.valueOf(cmbRoomTypeID.getValue());

        try {
            if (reservationBO.saveReservation(new ReservationDTO(recID, sqlDate, status, stuID, roomID))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
//                Clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnAction(ActionEvent actionEvent) {

    }

    public void setIds(){
        List<String> stIds=reservationBO.getStudentIds ();
        ObservableList student = FXCollections.observableArrayList (stIds);
        cmbStudentID.setItems (student);

        List<String> roomIds=reservationBO.getRoomIds ();
        ObservableList room = FXCollections.observableArrayList (roomIds);
        cmbRoomTypeID.setItems (room);

    }

//    public StudentDTO getStudnetDetail(){
//        String stId=cmbStudentID.getValue ().toString ();
//        return reservationBO.getStudent (stId);
//    }
//    public RoomDTO getRoomDetail(){
//        String roomId=cmbRoomTypeID.getValue ().toString ();
//        return reservationBO.getRoom (roomId);
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    setIds();
    }
}
