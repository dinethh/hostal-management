package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.StudentBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.StudentDAO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;
import lk.ijse.hibernate.coursework.entity.Student;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :10:00 AM
 * Name  :ORM-CourseWork
 */

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private Session session;

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        List<StudentDTO> allStudents = new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            allStudents.add(new StudentDTO(
                    student.getStudent_id(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact_no(),
                    student.getDob(),
                    student.getGender()));
        }
        return allStudents;
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(
                studentDTO.getStudent_id(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getStudent_id(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO searchStudent(String id) throws Exception {
        Student student = studentDAO.search(id);
        return new StudentDTO(
                student.getStudent_id(),
                student.getName(),
                student.getAddress(),
                student.getContact_no(),
                student.getDob(),
                student.getGender());
    }
}
