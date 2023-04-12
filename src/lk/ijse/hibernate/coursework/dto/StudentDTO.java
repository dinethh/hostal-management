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
public class StudentDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
}
