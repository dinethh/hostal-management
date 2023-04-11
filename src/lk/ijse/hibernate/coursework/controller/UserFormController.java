package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dto.UserDTO;

/**
 * Author:Dineth Panditha
 * Date  :4/2/2023
 * Time  :8:41 AM
 * Name  :ORM-CourseWork
 */

public class UserFormController {

    public JFXTextField txtUserID;
    public JFXTextField txtPassword;
    public JFXTextField txtUserName;
    public JFXButton btnSave;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void saveUserOnAction(ActionEvent actionEvent) {
        String userID = txtUserID.getText();
        String password = txtPassword.getText();
        String userName = txtUserName.getText();

        try {
            if (userBO.saveUser(new UserDTO(userID, password, userName))) {
                Clear();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Delete
    public void onActionDeleteUser(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are Your Sure ! ", ButtonType.NO, ButtonType.YES);
        alert.showAndWait();
        if (alert.getResult().equals(ButtonType.YES)) {
            try {
                if (userBO.deleteUser(txtUserID.getText())) {
                    Clear();
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Update
    public void onActionUpdateUser(ActionEvent actionEvent) {
        UserDTO user = new UserDTO(
                txtUserID.getText(),
                txtUserName.getText(),
                txtPassword.getText());
        try {
            if (userBO.updateUser(user)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();

                Clear();
            }else {
                new Alert(Alert.AlertType.ERROR, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Search
    public void onActionSearchUser(ActionEvent actionEvent) {
        UserDTO user;
        try {
            user = userBO.searchUser(txtUserID.getText());
            if (user != null) {
                fillData(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillData(UserDTO user) {
        txtPassword.setText(user.getPassword());
        txtUserName.setText(user.getUser_name());
    }

    private void Clear() {
        txtUserID.clear();
        txtUserName.clear();
        txtPassword.clear();
    }

}

