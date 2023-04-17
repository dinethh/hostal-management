package lk.ijse.hibernate.coursework.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * Author:Dineth Panditha
 * Date  :4/17/2023
 * Time  :9:33 PM
 * Name  :ORM-CourseWork
 */

public class Notification {
    public static void notification(String text) {
        Notifications.create()
                .title("D24 HOSTEL\n\n")
                .graphic(new ImageView("lk/ijse/hibernate/coursework/view/assests/tic.png"))
                .text(text).
                darkStyle()
                .hideAfter(Duration.seconds(3))
                .show();

    }

}
