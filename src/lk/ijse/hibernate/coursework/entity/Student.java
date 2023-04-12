package lk.ijse.hibernate.coursework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:13 PM
 * Name  :ORM-CourseWork
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
    @Id
    @Column(name = "student_id", length = 10)
    private String student_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_no")
    private String contact_no;
    @Column(name = "dbo")
    private String dob;
    @Column(name = "gender")
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private List<Reservation> reservationList = new ArrayList<>();

//    public Student(String student_id, String name, String address, String contact_no, String dob, String gender) {
//
//    }
}
