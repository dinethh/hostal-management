package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.RoomBO;
import lk.ijse.hibernate.coursework.dto.RoomDTO;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public JFXComboBox cmbRoomTypeID;
    public TableColumn colAvailableQTY;
    public Label lblTotal;
    public Label lblKeyMoney;
    public Label lblQty;
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    private Matcher keyMoneyMatcher;
    private Matcher qtyMatcher;

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
        if (keyMoneyMatcher.matches()) {
            if (qtyMatcher.matches()) {
                try {
                    if (roomBO.saveRoom(new RoomDTO(roomID, type, keyMoney, qty))) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
                        setDataTable();
                        Clear();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                txtQTY.requestFocus();
                txtQTY.setFocusColor(Paint.valueOf("Red"));
                lblQty.setText("Invalid Input");
            }
        } else {
            txtKeyMoney.requestFocus();
            txtKeyMoney.setFocusColor(Paint.valueOf("Red"));
            lblKeyMoney.setText("Invalid Input");
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
                setDataTable();
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
                    setDataTable();
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
        setPatterns();
    }

    private void Clear() {
        txtRoomID.clear();
        txtQTY.clear();
        txtKeyMoney.clear();
        cmbRoomType.setValue("");
    }

    public void onActioncmbRoomType(ActionEvent actionEvent) {
//        String tid = String.valueOf(cmbRoomType.getValue());
//        if (tid.equals("Non-AC")) {
//            txtKeyMoney.setText("3100.00");
//        }
//        if (tid.equals("Non-AC / Food")) {
//            txtKeyMoney.setText("6500.00");
//        }
//        if (tid.equals("AC")) {
//            txtKeyMoney.setText("8900.00");
//        }
//        if (tid.equals("AC / Food ")) {
//            txtKeyMoney.setText("16000.00");
//        }
    }

    public void onActionCalculateTotal(KeyEvent keyEvent) {
//        double getqty = Double.parseDouble(txtQTY.getText());
//        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
//        double result = getqty * keyMoney;
//        txtKeyMoney.setText(String.valueOf(result));
    }

    private void setPatterns() {
        Pattern keymoneyPattern = Pattern.compile("^[0-9]{4}$");
        keyMoneyMatcher = keymoneyPattern.matcher(txtKeyMoney.getText());

        Pattern qtyPattern = Pattern.compile("^[0-9]{2}$");
        qtyMatcher = qtyPattern.matcher(txtQTY.getText());
    }

    public void txtKeyMoneyOnKeyReleased(KeyEvent keyEvent) {
        lblKeyMoney.setText("");
        txtKeyMoney.setFocusColor(Paint.valueOf("Blue"));

        Pattern keymoneyPattern = Pattern.compile("^[0-9]{4}$");
        keyMoneyMatcher = keymoneyPattern.matcher(txtKeyMoney.getText());


        if (!keyMoneyMatcher.matches()) {
            txtKeyMoney.requestFocus();
            txtKeyMoney.setFocusColor(Paint.valueOf("Red"));
            lblKeyMoney.setText("invalid Input");
        }
    }

    public void txtQTYOnKeyReleased(KeyEvent keyEvent) {
        lblQty.setText("");
        txtQTY.setFocusColor(Paint.valueOf("Blue"));

        Pattern qtyPattern = Pattern.compile("^[0-9]{2}$");
        qtyMatcher = qtyPattern.matcher(txtQTY.getText());

        if (!qtyMatcher.matches()) {
            txtQTY.requestFocus();
            txtQTY.setFocusColor(Paint.valueOf("Red"));
            lblQty.setText("invalid Input");
        }
    }
}
