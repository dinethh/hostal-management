package lk.ijse.hibernate.coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:07 PM
 * Name  :ORM-CourseWork
 */

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource
                ("/lk/ijse/hibernate/coursework/view/MainMenuForm.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Hostel Management System");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
