package com.falalurahman.sacmessapp.Pojo;

import java.time.LocalDate;

public class StudentRegistration {
    private String RollNo;
    private String Name;
    private String MessCardNo;
    private LocalDate RegistrationDate;

    public StudentRegistration() {
    }

    public StudentRegistration(String rollNo, String name, String messCardNo, LocalDate registrationDate) {
        RollNo = rollNo;
        Name = name;
        MessCardNo = messCardNo;
        RegistrationDate = registrationDate;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessCardNo() {
        return MessCardNo;
    }

    public void setMessCardNo(String messCardNo) {
        MessCardNo = messCardNo;
    }

    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        RegistrationDate = registrationDate;
    }
}
