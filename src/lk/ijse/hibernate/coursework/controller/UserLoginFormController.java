package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dto.UserDTO;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :9:56 AM
 * Name  :ORM-CourseWork
 */

public class UserLoginFormController {

    public JFXTextField userName;
    public JFXTextField password;
    UserBO userBO= (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void userLoginOnAction(ActionEvent actionEvent) {
        String UserName=userName.getText();
        String Password=password.getText();
        try {
            if (userBO.saveUser(new UserDTO(UserName,Password))){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
