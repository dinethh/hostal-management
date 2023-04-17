package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.RoomDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:39 PM
 * Name  :ORM-CourseWork
 */

@Entity
public class Room extends RoomDTO {
    @Id
    @Column(name = "room_type_id", length = 10)
    private String room_type_id;
    @Column(name = "type")
    private String type;
    @Column(name = "key_money")
    private double key_money;
    @Column(name = "qty")
    private int qty;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "room")
    List<Reservation> reservationList;

    public Room() {
    }

    public Room(String room_type_id, String type, double key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getKey_money() {
        return key_money;
    }

    public void setKey_money(double key_money) {
        this.key_money = key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_type_id='" + room_type_id + '\'' +
                ", type='" + type + '\'' +
                ", key_money=" + key_money +
                ", qty=" + qty +
                '}';
    }
}
