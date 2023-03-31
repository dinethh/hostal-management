package lk.ijse.hibernate.coursework.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:13 PM
 * Name  :ORM-CourseWork
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
      @Id
      private String student_id;
      private String name;
      private String address;
      private String contact_no;
      private Date dob;
      private String gender;

}
