package lk.ijse.hibernate.coursework.dto;

import lombok.*;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :10:03 AM
 * Name  :ORM-CourseWork
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO {
  private String room_type_id;
  private String type;
  private double key_money;
  private int qty;

}
