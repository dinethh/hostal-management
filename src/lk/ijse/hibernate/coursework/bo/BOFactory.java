package lk.ijse.hibernate.coursework.bo;

import lk.ijse.hibernate.coursework.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hibernate.coursework.bo.custom.impl.RoomBOImpl;
import lk.ijse.hibernate.coursework.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.coursework.bo.custom.impl.UserBOImpl;

/**
 * Author:Dineth Panditha
 * Date  :3/31/2023
 * Time  :2:01 PM
 * Name  :ORM-CourseWork
 */

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {

        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {USER, STUDENT, ROOM, RESERVATION}
}
