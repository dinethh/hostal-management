package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dto.UserDTO;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:Dineth Panditha
 * Date  :4/2/2023
 * Time  :8:41 AM
 * Name  :ORM-CourseWork
 */

public class UserFormController implements Initializable {

    public JFXTextField txtUserID;
    public JFXTextField txtPassword;
    public JFXTextField txtUserName;
    public JFXButton btnSave;
    public Label lblUserName;
    public Label lblPassword;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    private Matcher userNameMatcher;
    private Matcher pwMatcher;

    public void saveUserOnAction(ActionEvent actionEvent) {
        String userID = txtUserID.getText();
        String password = txtPassword.getText();
        String userName = txtUserName.getText();
        if (userNameMatcher.matches()) {
            if (pwMatcher.matches()) {
                try {
                    if (userBO.saveUser(new UserDTO(userID, userName, password))) {
                        Clear();
                        new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Paint.valueOf("Red"));
                lblPassword.setText("Invalid Password");
            }
        } else {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            lblUserName.setText("Invalid user name");
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
            } else {
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
//    Rejex Part =====================

    private void setPatterns() {
        Pattern userNamePattern = Pattern.compile("[A-Za-z ]+");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());
        Pattern pwPattern = Pattern.compile("^[0-9]{4}$");
        pwMatcher = pwPattern.matcher(txtPassword.getText());
    }

    public void txtUserNameKeyTypedOnAction(KeyEvent keyEvent) {
        lblUserName.setText("");
        txtUserName.setFocusColor(Paint.valueOf("Blue"));

        Pattern userNamePattern = Pattern.compile("[A-Za-z ]+");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());

        if (!userNameMatcher.matches()) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            lblUserName.setText("invalid user name");
        }
    }

    public void txtPasswordKeyTypedOnAction(KeyEvent keyEvent) {
        lblPassword.setText("");
        txtPassword.setFocusColor(Paint.valueOf("Blue"));

        Pattern pwPattern = Pattern.compile("^[0-9]{4}$");
        pwMatcher = pwPattern.matcher(txtPassword.getText());

        if (!pwMatcher.matches()) {
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            lblPassword.setText("invalid Password");
        }
    }

    public void addUserOnMouseClicked(MouseEvent mouseEvent) throws Exception {
        txtUserID.setDisable(false);
        txtUserName.setDisable(false);
        txtPassword.setDisable(false);
        btnUpdate.setDisable(false);
        btnSave.setDisable(false);
        btnDelete.setDisable(false);
        txtUserID.setText(generateNewIds());
    }

    private String generateNewIds() throws Exception {
        try {
            return userBO.generateNewUserID();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new id " + e.getMessage()).show();
            e.printStackTrace();
        }
        return "USER-001";
    }

    private void setDisable() {
        txtUserID.setDisable(true);
        txtUserName.setDisable(true);
        txtPassword.setDisable(true);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDisable();
        setPatterns();
    }


}

