package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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

                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        if (btnSave.getText().equalsIgnoreCase("Save User")) {
//            try {
//                userBO.saveUser(new UserDTO(userID, password, userName));
//                new Alert(Alert.AlertType.CONFIRMATION, "User is Saved..! ").show();
//            } catch (Exception e) {
//                e.printStackTrace();
////                new Alert(Alert.AlertType.WARNING, "Try Again..! ").show();
//
//            }
//        }else { new Alert(Alert.AlertType.WARNING, "Try Again..! ").show();}
    }
    }

