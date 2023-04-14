package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.ReservationBO;
import lk.ijse.hibernate.coursework.dto.ReservationDTO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

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
    public TableColumn colQTYrec;
    public JFXTextField txtQtyfromREC;


    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public void SavaOnAction(ActionEvent actionEvent) {
//        StudentDTO studentDTO=getStudnetDetail ();
//        RoomDTO roomDTO=getRoomDetail ();
//        String resID=txtResID.getText();
//        String status=cmbStatus.getValue().toString();
//        java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//
//        try {
//            boolean isSaveReservation = reservationBO.saveReservation (
//                    new ReservationDTO (
//                            resID,
//                            sqlDate,
//                            studentDTO,
//                            roomDTO,
//                            status
//                    ));
//            if (isSaveReservation){
//                RoomDTO room=getRoomDetail ();
//                System.out.println (room.getQty ()-1);
//                room.setQty (room.getQty ()-1);
//                reservationBO.updateRoom (room);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace ();
//        }

    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnAction(ActionEvent actionEvent) {

    }

    public void setIds() {
        List<String> stIds = reservationBO.getStudentIds();
        ObservableList student = FXCollections.observableArrayList(stIds);
        cmbStudentID.setItems(student);

        List<String> roomIds = reservationBO.getRoomIds();
        ObservableList room = FXCollections.observableArrayList(roomIds);
        cmbRoomTypeID.setItems(room);

    }

    public void setStatus(){
        ObservableList<String> data = FXCollections.observableArrayList ("PAID", "UNPAID");
        cmbStatus.setItems (data);
    }

    public StudentDTO getStudnetDetail(){
        String stId=cmbStudentID.getValue ().toString ();
        return reservationBO.getStudent (stId);
    }
    public RoomDTO getRoomDetail(){
        String roomId=cmbRoomTypeID.getValue ().toString ();
        return reservationBO.getRoom (roomId);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIds();
        setStatus();
    }
}
