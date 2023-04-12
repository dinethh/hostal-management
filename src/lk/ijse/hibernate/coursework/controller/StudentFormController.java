package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.StudentBO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author:Dineth Panditha
 * Date  :4/1/2023
 * Time  :9:03 AM
 * Name  :ORM-CourseWork
 */

public class StudentFormController implements Initializable {
    public JFXDatePicker datePickerDOB;
    public JFXComboBox cmbGender;
    public JFXTextField txtStudentID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtDOB;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void SaveStudentOnAction(ActionEvent actionEvent) {

        String name = txtName.getText();
        String studentID = txtStudentID.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String date = txtDOB.getText();
        String gender = String.valueOf(cmbGender.getValue());



    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {

    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {

    }

    public void SearchStudentIDonAction(ActionEvent actionEvent) {

    }

    private void setGender() {
        String[] gender = {"Male", "Female"};
        cmbGender.getItems().addAll(gender);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGender();
    }


    private void Clear(){
        txtStudentID.clear();
        txtAddress.clear();
        txtContact.clear();
        txtName.clear();
      }
}
