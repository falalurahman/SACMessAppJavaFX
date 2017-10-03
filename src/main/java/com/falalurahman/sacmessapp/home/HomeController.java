package com.falalurahman.sacmessapp.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.ScrollPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{

    @FXML
    private GridPane rootPane;

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

    private Pane newPane = null;
    private ScrollPane scrollPane = null;


    public void initialize(URL location, ResourceBundle resources){
        setNavItemSelected(0);
        student_reg_button.setOnMouseClicked(event -> setNavItemSelected(0));
        student_extra_button.setOnMouseClicked(event -> setNavItemSelected(1));
        mess_leave_button.setOnMouseClicked(event -> setNavItemSelected(2));
        student_details_button.setOnMouseClicked(event -> setNavItemSelected(3));
        add_extra_button.setOnMouseClicked(event -> setNavItemSelected(5));
    }

    private void setNavItemSelected(int itemSelected){
        try {
            switch (itemSelected) {
                case 0:
                    rootPane.getChildren().removeAll(newPane, scrollPane);
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/studentRegistration/studentRegistration.fxml"));
                    rootPane.add(newPane,1, 0 , 1 , 9);
                    student_reg_button.getStyleClass().add("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_details_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 1:
                    rootPane.getChildren().removeAll(newPane, scrollPane);
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/studentExtra/studentExtra.fxml"));
                    rootPane.add(newPane,1, 0 , 1 , 9);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().add("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_details_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 2:
                    rootPane.getChildren().removeAll(newPane, scrollPane);
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/messLeave/messLeave.fxml"));
                    rootPane.add(newPane,1, 0 , 1 , 9);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().add("nav_bar_buttons_selected");
                    student_details_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 3:
                    rootPane.getChildren().removeAll(newPane, scrollPane);
                    scrollPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/studentDetails/studentDetails.fxml"));
                    rootPane.add(scrollPane,1, 0 , 1 , 9);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_details_button.getStyleClass().add("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    break;
                case 5:
                    rootPane.getChildren().removeAll(newPane, scrollPane);
                    newPane = FXMLLoader.load(getClass().getResource("/com/falalurahman/sacmessapp/addExtras/addExtras.fxml"));
                    rootPane.add(newPane,1, 0 , 1 , 9);
                    student_reg_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_extra_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    mess_leave_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    student_details_button.getStyleClass().removeAll("nav_bar_buttons_selected");
                    add_extra_button.getStyleClass().add("nav_bar_buttons_selected");
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
