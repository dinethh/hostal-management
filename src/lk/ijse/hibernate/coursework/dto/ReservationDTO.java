package lk.ijse.hibernate.coursework.dto;

import java.sql.Date;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :10:06 AM
 * Name  :ORM-CourseWork
 */

public class ReservationDTO {
    private String resId;
    private Date date;
    private String student_id;
    private String room_type_id;
    private String status;
    private StudentDTO studentDTO;
    private RoomDTO roomDTO;

    public ReservationDTO() {
    }

    public ReservationDTO(String resId, Date date, String student_id, String room_type_id, String status) {
        this.resId = resId;
        this.date = date;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.status = status;
        this.studentDTO = studentDTO;
        this.roomDTO = roomDTO;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", student_id='" + student_id + '\'' +
                ", room_type_id='" + room_type_id + '\'' +
                ", status='" + status + '\'' +
                ", studentDTO=" + studentDTO +
                ", roomDTO=" + roomDTO +
                '}';
    }
}
