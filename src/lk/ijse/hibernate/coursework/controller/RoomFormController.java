package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.RoomBO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author:Dineth Panditha
 * Date  :4/1/2023
 * Time  :9:58 AM
 * Name  :ORM-CourseWork
 */

public class RoomFormController implements Initializable {

    public JFXTextField txtRoomID;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQTY;
    public JFXComboBox cmbRoomType;

    public TableView tblRoom;
    public TableColumn colRoomID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQTY;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    private void setDataTable() {
        tblRoom.getItems().clear();
        try {
            for (RoomDTO r : roomBO.getAllRoom()) {
                tblRoom.getItems().add(new RoomDTO(
                        r.getRoom_type_id(),
                        r.getType(),
                        r.getKey_money(),
                        r.getQty()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {

        String roomID = txtRoomID.getText();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
        int qty = Integer.parseInt(txtQTY.getText());
        String type = String.valueOf(cmbRoomType.getValue());

        try {
            if (roomBO.saveRoom(new RoomDTO(roomID, type, keyMoney, qty))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
                Clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        RoomDTO room = new RoomDTO(
                txtRoomID.getText(),
                cmbRoomType.getId(),
                Double.parseDouble(txtKeyMoney.getText()),
                Integer.parseInt(txtQTY.getText()));

        try {
            if (roomBO.updateRoom(room)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                Clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are Your Sure ! ", ButtonType.NO, ButtonType.YES);
        alert.showAndWait();
        if (alert.getResult().equals(ButtonType.YES)) {
            try {
                if (roomBO.deleteRoom(txtRoomID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                    Clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        RoomDTO room;
        try {
            room = roomBO.searchRoom(txtRoomID.getText());
            if (room != null) {
                fillData(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTblValues() {
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));

    }

    private void fillData(RoomDTO room) {
        txtRoomID.setText(room.getRoom_type_id());
        cmbRoomType.setValue(room.getType());
        txtKeyMoney.setText(String.valueOf(room.getKey_money()));
        txtQTY.setText(String.valueOf(room.getQty()));
    }

    private void setType() {
        String[] gender = {"Non-AC", "Non-AC / Food", "AC", "AC / Food "};
        cmbRoomType.getItems().addAll(gender);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setType();
        setTblValues();
        setDataTable();
    }

    private void Clear() {
        txtRoomID.clear();
        txtQTY.clear();
        txtKeyMoney.clear();
        cmbRoomType.setValue("");
    }
}
