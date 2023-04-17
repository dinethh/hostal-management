package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :3:11 PM
 * Name  :ORM-CourseWork
 */

public class MainMenuController implements Initializable {
    public AnchorPane MyPane;
    public JFXButton btn;


    public void setNode(Node node) {
        MyPane.getChildren().clear();
        MyPane.getChildren().add(node);
    }

    public void onClickUser(MouseEvent mouseEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../view/UserForm.fxml"));
        setNode(node);
    }

    public void OnClickStudent(MouseEvent mouseEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../view/StudentForm.fxml"));
        setNode(node);
    }

    public void OnClickRoom(MouseEvent mouseEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../view/RoomForm.fxml"));
        setNode(node);
    }

    public void OnClickReservation(MouseEvent mouseEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../view/ReservationForm.fxml"));
        setNode(node);
    }

    public void onClickDashboard(MouseEvent mouseEvent) throws IOException {
//        Node node = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
//        setNode(node);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn.fire();
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"));
        setNode(node);
    }
}
