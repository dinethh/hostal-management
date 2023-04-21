package lk.ijse.hibernate.coursework.dao.custom;

import com.sun.xml.bind.v2.model.core.ID;
import lk.ijse.hibernate.coursework.dao.CrudDAO;
import lk.ijse.hibernate.coursework.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    List<String> getStIds();
}
