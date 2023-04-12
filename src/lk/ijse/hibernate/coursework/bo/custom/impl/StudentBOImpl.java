package lk.ijse.hibernate.coursework.bo.custom.impl;

import lk.ijse.hibernate.coursework.bo.custom.StudentBO;
import lk.ijse.hibernate.coursework.dao.DAOFactory;
import lk.ijse.hibernate.coursework.dao.custom.StudentDAO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.util.ArrayList;

/**
 * Author:Dineth Panditha
 * Date  :4/12/2023
 * Time  :10:00 AM
 * Name  :ORM-CourseWork
 */

public class StudentBOImpl implements StudentBO {
   StudentDAO studentDAO= (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

   @Override
   public ArrayList<StudentDTO> getAllStudent() throws Exception {
      return null;
   }

   @Override
   public boolean saveStudent(StudentDTO studentDTO) throws Exception {
      return false;
   }

   @Override
   public boolean updateStudent(StudentDTO studentDTO) throws Exception {
      return false;
   }

   @Override
   public boolean deleteStudent(String id) throws Exception {
      return false;
   }

   @Override
   public StudentDTO searchStudent(String id) throws Exception {
      return null;
   }
}
