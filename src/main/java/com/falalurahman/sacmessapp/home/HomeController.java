package com.falalurahman.sacmessapp.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{

    @FXML
    private HBox screen;

    @FXML
    private HBox student_reg_button;

    @FXML
    private HBox student_extra_button;

    @FXML
    private HBox mess_leave_button;

    @FXML
    private HBox student_details_button;

    @FXML
    private HBox registered_students_button;

    @FXML
    private HBox add_extra_button;

    @FXML
    private HBox settings_button;


    public void initialize(URL location, ResourceBundle resources){
        setNavItemSelected(0);
        student_reg_button.setOnMouseClicked(event -> setNavItemSelected(0));
        student_extra_button.setOnMouseClicked(event -> setNavItemSelected(1));
        mess_leave_button.setOnMouseClicked(event -> setNavItemSelected(2));
        add_extra_button.setOnMouseClicked(event -> setNavItemSelected(5));
    }

    private void setNavItemSelected(int itemSelected){
        Pane newPane = null;
        try {
            switch (itemSelected) {
                case 0:
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/studentRegistration/studentRegistration.fxml"));
                    screen.getChildren().clear();
                    screen.getChildren().add(newPane);
                    student_reg_button.getStyleClass().add("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 1:
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/studentExtra/studentExtra.fxml"));
                    screen.getChildren().clear();
                    screen.getChildren().add(newPane);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().add("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 2:
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/messLeave/messLeave.fxml"));
                    screen.getChildren().clear();
                    screen.getChildren().add(newPane);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().add("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 5:
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/addExtras/addExtras.fxml"));
                    screen.getChildren().clear();
                    screen.getChildren().add(newPane);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().add("nav_bar_buttons_selected");
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
