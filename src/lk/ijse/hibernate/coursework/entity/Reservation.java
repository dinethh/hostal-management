package lk.ijse.hibernate.coursework.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Author:Dineth Panditha
 * Date  :4/11/2023
 * Time  :8:59 PM
 * Name  :ORM-CourseWork
 */

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @Column(name = "resId", length = 10)
    private String resId;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private Room room;

    @Column(name = "status")
    private String status;


    public Reservation() {
    }

    public Reservation(String resId, Date date, Student student, Room room, String status) {
        this.resId = resId;
        this.date = date;
        this.student = student;
        this.room = room;
        this.status = status;
    }

    public Reservation(String resId, Date date, String student_id, String room_type_id, String status) {

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", student=" + student +
                ", room=" + room +
                ", status='" + status + '\'' +
                '}';
    }
}
