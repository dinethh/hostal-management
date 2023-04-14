package lk.ijse.hibernate.coursework.dao.custom;

import lk.ijse.hibernate.coursework.dao.CrudDAO;
import lk.ijse.hibernate.coursework.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    List<String> getStIds();
}
