package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    public TableView tblStudent;
    public TableColumn colStudentID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    private void setDataTable() {
        tblStudent.getItems().clear();
        try {
            for (StudentDTO s : studentBO.getAllStudent()) {
                tblStudent.getItems().add(new StudentDTO(
                        s.getStudent_id(),
                        s.getName(),
                        s.getAddress(),
                        s.getContact_no(),
                        s.getDob(),
                        s.getGender()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveStudentOnAction(ActionEvent actionEvent) {

        String studentID = txtStudentID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String date = txtDOB.getText();
        String gender = String.valueOf(cmbGender.getValue());

        try {
            if (studentBO.saveStudent(new StudentDTO(studentID, name, address, contact, date, gender))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..!").show();
               setDataTable();
                Clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
        StudentDTO student = new StudentDTO(
                txtStudentID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                txtDOB.getText(),
                String.valueOf(cmbGender.getValue()));

        try {
            if (studentBO.updateStudent(student)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                setDataTable();
                Clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again..!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are Your Sure ! ", ButtonType.NO, ButtonType.YES);
        alert.showAndWait();
        if (alert.getResult().equals(ButtonType.YES)) {
            try {
                if (studentBO.deleteStudent(txtStudentID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                    setDataTable();
                    Clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void SearchStudentIDonAction(ActionEvent actionEvent) {
        StudentDTO student;
        try {
            student = studentBO.searchStudent(txtStudentID.getText());
            if (student != null) {
                fillData(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillData(StudentDTO student) {
        txtStudentID.setText(student.getStudent_id());
        txtName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtContact.setText(student.getContact_no());
        txtDOB.setText(student.getDob());
        cmbGender.setValue(student.getGender());
    }

    public void setTblValues() {
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void setGender() {
        String[] gender = {"Male", "Female"};
        cmbGender.getItems().addAll(gender);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setGender();
        setDataTable();
        setTblValues();
    }


    private void Clear() {
        txtStudentID.clear();
        txtAddress.clear();
        txtContact.clear();
        txtName.clear();
        cmbGender.setValue("");
    }
}
