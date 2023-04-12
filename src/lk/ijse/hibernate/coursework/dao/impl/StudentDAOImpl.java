package lk.ijse.hibernate.coursework.dao.impl;

import lk.ijse.hibernate.coursework.dao.custom.StudentDAO;
import lk.ijse.hibernate.coursework.entity.Student;
import org.hibernate.Session;

import java.util.ArrayList;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :10:01 AM
 * Name  :ORM-CourseWork
 */

public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getAll() {
        return null;
    }

    @Override
    public boolean save(Student entity) {
        return false;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Student search(String id) {
        return null;
    }


    @Override
    public void setSession(Session session) {
//        this.session=session;
    }
}
