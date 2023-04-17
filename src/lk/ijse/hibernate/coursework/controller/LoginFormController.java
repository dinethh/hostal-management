package lk.ijse.hibernate.coursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.util.Navigation;
import lk.ijse.hibernate.coursework.util.Notification;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :9:56 AM
 * Name  :ORM-CourseWork
 */

public class LoginFormController implements Initializable {


    public ImageView passwordEyeClose;
    public TextField userName;
    public PasswordField password;
    public ImageView imgOpen;
    public TextField txtShowPassword;
    public Label lblForget;


    public void userLoginOnAction(ActionEvent actionEvent) throws IOException {

        Session session = SessionFactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("from User where user_name=:user_name and password=:password");
        query.setParameter("user_name", userName.getText());
        query.setParameter("password", password.getText());
        User user = (User) query.uniqueResult();
        if (user != null) {
            Navigation.swatchNavigation("MainMenuForm.fxml", actionEvent);
            Notification.notification ("Login Successfully");
        } else {
            lblForget.setText("Please Check Your Entered");
        }
        session.close();
    }

    public void eyeClosedOnAction(MouseEvent mouseEvent) {
        passwordEyeClose.setVisible(false);
        imgOpen.setVisible(true);
        txtShowPassword.setVisible(false);
        password.setVisible(true);
    }

    public void OnClickEyeOpen(MouseEvent mouseEvent) {
        passwordEyeClose.setVisible(true);
        txtShowPassword.setVisible(true);
        txtShowPassword.setText(password.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        passwordEyeClose.setVisible(false);
        imgOpen.setVisible(true);
        password.setVisible(true);
        txtShowPassword.setVisible(false);
    }


}

