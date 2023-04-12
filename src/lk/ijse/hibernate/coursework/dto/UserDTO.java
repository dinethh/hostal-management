package lk.ijse.hibernate.coursework.dto;

import lombok.*;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :2:36 PM
 * Name  :ORM-CourseWork
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String userId;
    private String user_name;
    private String password;
}
