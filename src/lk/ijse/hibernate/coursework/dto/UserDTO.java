package lk.ijse.hibernate.coursework.dto;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :2:36 PM
 * Name  :ORM-CourseWork
 */

public class UserDTO {
    private String user_id;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id='" + user_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
