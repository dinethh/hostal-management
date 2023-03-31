package lk.ijse.hibernate.coursework.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :10:00 AM
 * Name  :ORM-CourseWork
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private String user_id;
    private String password;

}
