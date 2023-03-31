package lk.ijse.hibernate.coursework.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:39 PM
 * Name  :ORM-CourseWork
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Room {
    @Id
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;
}
