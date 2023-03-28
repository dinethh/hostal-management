package lk.ijse.hibernate.coursework.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Author:Dineth Panditha
 * Date  :3/28/2023
 * Time  :9:13 PM
 * Name  :ORM-CourseWork
 */
@Entity
public class Student {
      @Id
      private String student_id;
      private String name;
      private String address;
      private String contact_no;
      private Date dob;
      private String gender;

      public Student() {
      }

      public Student(String student_id, String name, String address, String contact_no, Date dob, String gender) {
            this.student_id = student_id;
            this.name = name;
            this.address = address;
            this.contact_no = contact_no;
            this.dob = dob;
            this.gender = gender;
      }

      public String getStudent_id() {
            return student_id;
      }

      public void setStudent_id(String student_id) {
            this.student_id = student_id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getAddress() {
            return address;
      }

      public void setAddress(String address) {
            this.address = address;
      }

      public String getContact_no() {
            return contact_no;
      }

      public void setContact_no(String contact_no) {
            this.contact_no = contact_no;
      }

      public Date getDob() {
            return dob;
      }

      public void setDob(Date dob) {
            this.dob = dob;
      }

      public String getGender() {
            return gender;
      }

      public void setGender(String gender) {
            this.gender = gender;
      }

      @Override
      public String toString() {
            return "Student{" +
                    "student_id='" + student_id + '\'' +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", contact_no='" + contact_no + '\'' +
                    ", dob=" + dob +
                    ", gender='" + gender + '\'' +
                    '}';
      }
}
