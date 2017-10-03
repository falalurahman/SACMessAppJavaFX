package com.falalurahman.sacmessapp.Pojo;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class StudentMessLeave {
    private LocalDate StartingDate;
    private LocalDate EndingDate;

    public StudentMessLeave() {
    }

    public StudentMessLeave(LocalDate startingDate, LocalDate endingDate) {
        StartingDate = startingDate;
        EndingDate = endingDate;
    }

    public StudentMessLeave(LocalDate startingDate, LocalDate endingDate, int noOfDays) {
        StartingDate = startingDate;
        EndingDate = endingDate;
    }

    public LocalDate getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        StartingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return EndingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        EndingDate = endingDate;
    }

    public int getNoOfDays() {
        return (int) DAYS.between(StartingDate,EndingDate) + 1;
    }
}
