package lk.ijse.hibernate.coursework.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:45 PM
 * Name  :ORM-CourseWork
 */

public class Utility {

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader
                    .getSystemClassLoader()
                    .getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
            e.printStackTrace();
        }
        return properties;
    }
}
