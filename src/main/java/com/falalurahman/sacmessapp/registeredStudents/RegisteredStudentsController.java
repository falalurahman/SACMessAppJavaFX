package com.falalurahman.sacmessapp.registeredStudents;

import com.falalurahman.sacmessapp.Pojo.ExtraItem;
import com.falalurahman.sacmessapp.Pojo.StudentRegistration;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class RegisteredStudentsController implements Initializable {

    @FXML
    private TableView<StudentRegistration> studentTable;

    @FXML
    private TableColumn<StudentRegistration,Number> indexCol;

    @FXML
    private TableColumn<StudentRegistration,String> rollNoCol;

    @FXML
    private TableColumn<StudentRegistration,String> nameCol;

    @FXML
    private TableColumn<StudentRegistration,String> messCardNoCol;

    @FXML
    private TableColumn<StudentRegistration,String> regDateCol;

    @FXML
    private TableColumn<StudentRegistration,StudentRegistration> deleteCol;

    @FXML
    private JFXComboBox<String> messMonthCombo;

    private ObservableList<StudentRegistration> allStudents;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        indexCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(studentTable.getItems().indexOf(column.getValue()) + 1 ));
        rollNoCol.setCellValueFactory(new PropertyValueFactory<>("RollNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        messCardNoCol.setCellValueFactory(new PropertyValueFactory<>("MessCardNo"));
        messCardNoCol.setCellFactory(TextFieldTableCell.forTableColumn());
        messCardNoCol.setOnEditCommit(row -> row.getTableView().getItems().get(row.getTablePosition().getRow()).setMessCardNo(row.getNewValue()));
        regDateCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue().getRegistrationDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) ));
        regDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        regDateCol.setOnEditCommit(row -> row.getTableView().getItems().get(row.getTablePosition().getRow()).setRegistrationDate(LocalDate.parse(row.getNewValue(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        deleteCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue() ));
        deleteCol.setCellFactory(param -> new TableCell<StudentRegistration,StudentRegistration>(){
            private final JFXButton deleteButton = new JFXButton("Delete");

            @Override
            protected void updateItem(StudentRegistration item, boolean empty) {
                super.updateItem(item,empty);
                if(item == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> studentTable.getItems().removeAll(item));
                deleteButton.setButtonType(JFXButton.ButtonType.RAISED);
                deleteButton.setRipplerFill(Paint.valueOf("#005b4f"));
                deleteButton.getStyleClass().add("green_button");
                deleteButton.setStyle("-fx-text-fill: #FFFFFF");
            }
        });

        allStudents = getStudents();
        studentTable.setItems(allStudents);

        messMonthCombo.getItems().addAll("August 2017", "September 2017");
    }

    private ObservableList<StudentRegistration> getStudents(){
        ObservableList<StudentRegistration> observableList = FXCollections.observableArrayList(
                new StudentRegistration("B140347CS","Falalu Rahman","12345", Instant.ofEpochSecond(1506882600).atZone(ZoneId.systemDefault()).toLocalDate())
        );
        return observableList;
    }
}
