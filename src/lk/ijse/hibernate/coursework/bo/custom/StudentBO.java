package lk.ijse.hibernate.coursework.bo.custom;

import lk.ijse.hibernate.coursework.bo.SuperBO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> getAllStudent() throws Exception;

    boolean saveStudent(StudentDTO studentDTO) throws Exception;

    boolean updateStudent(StudentDTO studentDTO) throws Exception;

    boolean deleteStudent(String id) throws Exception;

    StudentDTO searchStudent(String id) throws Exception;

    String generateNewStudentID() throws Exception;
}
