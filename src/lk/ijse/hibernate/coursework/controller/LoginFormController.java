package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.UserBO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.util.Navigation;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :9:56 AM
 * Name  :ORM-CourseWork
 */

public class LoginFormController {

    public JFXTextField userName;
    public JFXTextField password;


    public void userLoginOnAction(ActionEvent actionEvent) throws IOException {

       Session session = SessionFactoryConfiguration.getInstance().getSession();

        /*Get record using HQL query*/
        Query query=session.createQuery("from User where user_name=:user_name and password=:password");
        query.setParameter("user_name", userName.getText());
        query.setParameter("password", password.getText());
        User user=(User)query.uniqueResult();
        if(user!=null) {
            Navigation.swatchNavigation("MainMenuForm.fxml", actionEvent);
        }else {
            new Alert(Alert.AlertType.ERROR, "Check User Name and Password").show();
        }
        session.close();
    }
    }

