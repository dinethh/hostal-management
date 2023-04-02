package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :3:11 PM
 * Name  :ORM-CourseWork
 */

public class MainMenuController {
    public AnchorPane MyPane;
    public JFXButton btn;

    private void setNode(Node node) {
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
}
