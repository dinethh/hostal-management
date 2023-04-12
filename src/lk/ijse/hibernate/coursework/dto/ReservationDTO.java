package lk.ijse.hibernate.coursework.dto;

import lombok.*;

import java.sql.Date;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :10:06 AM
 * Name  :ORM-CourseWork
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO {
    private String resId;
    private Date date;
    private String student_id;
    private String room_type_id;
    private String status;
    private StudentDTO studentDTO;
    private RoomDTO roomDTO;
}
