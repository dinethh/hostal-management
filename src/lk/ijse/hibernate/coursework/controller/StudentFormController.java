package lk.ijse.hibernate.coursework.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import lk.ijse.hibernate.coursework.bo.BOFactory;
import lk.ijse.hibernate.coursework.bo.custom.StudentBO;
import lk.ijse.hibernate.coursework.dto.StudentDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:Dineth Panditha
 * Date  :4/1/2023
 * Time  :9:03 AM
 * Name  :ORM-CourseWork
 */

public class StudentFormController implements Initializable {

    public JFXComboBox cmbGender;
    public JFXTextField txtStudentID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;


    public TableView tblStudent;
    public TableColumn colStudentID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXDatePicker txtDOB;
    public Label lblName;
    public Label lblAddress;
    public Label lblContact;
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    private Matcher stuNameMatcher;
    private Matcher stuAddressMatcher;
    private Matcher stuContactMatcher;

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
        String date = String.valueOf(txtDOB.getValue());
        String gender = String.valueOf(cmbGender.getValue());

        if (stuNameMatcher.matches()) {
            if (stuAddressMatcher.matches()) {
                if (stuContactMatcher.matches()){
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
                }}else {
                    txtContact.requestFocus();
                    txtContact.setUnFocusColor(Paint.valueOf("Red"));
                    lblContact.setText("Invalid Number");
                }
            } else {txtAddress.requestFocus();
                txtAddress.setUnFocusColor(Paint.valueOf("Red"));
                lblAddress.setText("Invalid Address");
            }
        } else {
            txtName.requestFocus();
            txtName.setUnFocusColor(Paint.valueOf("Red"));
            lblName.setText("Invalid Name");
        }
    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
        StudentDTO student = new StudentDTO(
                txtStudentID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtContact.getText(),
                String.valueOf(txtDOB.getValue()),
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
        txtDOB.setValue(LocalDate.parse(student.getDob()));
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
        setPatterns();
    }


    private void Clear() {
        txtStudentID.clear();
        txtAddress.clear();
        txtContact.clear();
        txtName.clear();
//        cmbGender.getEditor().clear();
//        txtDOB.getEditor().clear();
        cmbGender.setValue(null);
        txtDOB.setValue(null);
    }

    //Rejex
    private void setPatterns() {
        Pattern studentNamePattern = Pattern.compile("^[a-zA-Z]{10}$");
        stuNameMatcher = studentNamePattern.matcher(txtName.getText());

        Pattern studentAddressPattern = Pattern.compile("^[a-zA-Z]{10}$");
        stuAddressMatcher = studentAddressPattern.matcher(txtAddress.getText());

        Pattern studentContactPattern = Pattern.compile("^[0-9]{10}$");
        stuContactMatcher = studentContactPattern.matcher(txtContact.getText());
    }

    public void txtNameOnKeyRelesed(KeyEvent keyEvent) {
        lblName.setText("");
        txtName.setUnFocusColor(Paint.valueOf("Blue"));
        Pattern studentNamePattern = Pattern.compile("^[a-zA-Z]{10}$");
        stuNameMatcher = studentNamePattern.matcher(txtName.getText());
        if (!stuNameMatcher.matches()) {
            txtName.requestFocus();
            txtName.setFocusColor(Paint.valueOf("Red"));
            lblName.setText("Invalid Name");
        }
    }

    public void txtAddressOnKeyRelesed(KeyEvent keyEvent) {
        lblAddress.setText("");
        txtAddress.setUnFocusColor(Paint.valueOf("Blue"));
        Pattern studentAddressPattern = Pattern.compile("^[a-zA-Z]{10}$");
        stuAddressMatcher = studentAddressPattern.matcher(txtAddress.getText());
        if (!stuAddressMatcher.matches()) {
            txtAddress.requestFocus();
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddress.setText("Invalid Address");
        }
    }

    public void txtContactOnKeyRelesed(KeyEvent keyEvent) {
        lblContact.setText("");
        txtContact.setUnFocusColor(Paint.valueOf("Blue"));
        Pattern studentContactPattern = Pattern.compile("^[0-9]{10}$");
        stuContactMatcher = studentContactPattern.matcher(txtContact.getText());
        if (!stuContactMatcher.matches()) {
            txtContact.requestFocus();
            txtContact.setFocusColor(Paint.valueOf("Red"));
            lblContact.setText("Invalid Number");
        }
    }
}
