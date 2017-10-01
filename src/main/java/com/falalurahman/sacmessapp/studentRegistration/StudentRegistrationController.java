package com.falalurahman.sacmessapp.studentRegistration;

import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable{

    @FXML
    private JFXDatePicker RegDate;

    public void initialize(URL location, ResourceBundle resources) {
        RegDate.setValue(LocalDate.now());
    }
}
