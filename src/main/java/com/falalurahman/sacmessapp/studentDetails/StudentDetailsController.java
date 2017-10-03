package com.falalurahman.sacmessapp.studentDetails;

import com.falalurahman.sacmessapp.Pojo.ExtraItem;
import com.falalurahman.sacmessapp.Pojo.StudentExtraItem;
import com.falalurahman.sacmessapp.Pojo.StudentMessLeave;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Paint;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentDetailsController implements Initializable {

    @FXML
    private TableView<StudentExtraItem> extraTable;

    @FXML
    private TableView<StudentMessLeave> messLeaveTable;

    @FXML
    private TableColumn<StudentExtraItem,Number> indexCol;

    @FXML
    private TableColumn<StudentExtraItem,String> nameCol;

    @FXML
    private TableColumn<StudentExtraItem,String> dateCol;

    @FXML
    private TableColumn<StudentExtraItem,String> qtyCol;

    @FXML
    private TableColumn<StudentExtraItem,Double> priceCol;

    @FXML
    private TableColumn<StudentExtraItem,StudentExtraItem> deleteCol;

    @FXML
    private TableColumn<StudentMessLeave,Number> indexMessLeaveCol;

    @FXML
    private TableColumn<StudentMessLeave,String> startingDateCol;

    @FXML
    private TableColumn<StudentMessLeave,String> endingDateCol;

    @FXML
    private TableColumn<StudentMessLeave,Integer> noOfDaysCol;

    @FXML
    private TableColumn<StudentMessLeave,StudentMessLeave> deleteMessLeaveCol;

    private ObservableList<StudentExtraItem> allExtraItems;
    private ObservableList<StudentMessLeave> allMessLeaves;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        indexCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(extraTable.getItems().indexOf(column.getValue()) + 1 ));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        dateCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( new SimpleDateFormat("dd-MM-yyyy").format(column.getValue().getItemDate()) ));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        deleteCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue() ));
        deleteCol.setCellFactory(param -> new TableCell<StudentExtraItem,StudentExtraItem>(){
            private final JFXButton deleteButton = new JFXButton("Delete");

            @Override
            protected void updateItem(StudentExtraItem item, boolean empty) {
                super.updateItem(item,empty);
                if(item == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> extraTable.getItems().removeAll(item));
                deleteButton.setButtonType(JFXButton.ButtonType.RAISED);
                deleteButton.setRipplerFill(Paint.valueOf("#005b4f"));
                deleteButton.getStyleClass().add("green_button");
                deleteButton.setStyle("-fx-text-fill: #FFFFFF");
            }
        });

        allExtraItems = getExtraItems();
        extraTable.setItems(allExtraItems);
        extraTable.setOnScroll(event -> event.consume());


        indexMessLeaveCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(messLeaveTable.getItems().indexOf(column.getValue()) + 1 ));
        startingDateCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue().getStartingDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) ));
        startingDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        startingDateCol.setOnEditCommit(row ->
        {
            row.getTableView().getItems().get(row.getTablePosition().getRow()).setStartingDate(LocalDate.parse(row.getNewValue(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            row.getTableView().getItems().set(row.getTablePosition().getRow(),row.getTableView().getItems().get(row.getTablePosition().getRow()));
        });
        endingDateCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue().getEndingDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) ));
        endingDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        endingDateCol.setOnEditCommit(row ->
        {
            row.getTableView().getItems().get(row.getTablePosition().getRow()).setEndingDate(LocalDate.parse(row.getNewValue(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            row.getTableView().getItems().set(row.getTablePosition().getRow(),row.getTableView().getItems().get(row.getTablePosition().getRow()));
        });
        noOfDaysCol.setCellValueFactory(new PropertyValueFactory<>("NoOfDays"));
        deleteMessLeaveCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue() ));
        deleteMessLeaveCol.setCellFactory(param -> new TableCell<StudentMessLeave,StudentMessLeave>(){
            private final JFXButton deleteButton = new JFXButton("Delete");

            @Override
            protected void updateItem(StudentMessLeave item, boolean empty) {
                super.updateItem(item,empty);
                if(item == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> messLeaveTable.getItems().removeAll(item));
                deleteButton.setButtonType(JFXButton.ButtonType.RAISED);
                deleteButton.setRipplerFill(Paint.valueOf("#005b4f"));
                deleteButton.getStyleClass().add("green_button");
                deleteButton.setStyle("-fx-text-fill: #FFFFFF");
            }
        });

        allMessLeaves = getMessLeaves();
        messLeaveTable.setItems(allMessLeaves);
        messLeaveTable.setOnScroll(event -> event.consume());

    }

    private ObservableList<StudentExtraItem> getExtraItems(){
        ObservableList<StudentExtraItem> observableList = FXCollections.observableArrayList(
                new StudentExtraItem("Snacks",new Date(),1.0,3.2),
                new StudentExtraItem("Pineapple",new Date(), 2.0, 24.0),
                new StudentExtraItem("Apple",new Date(),1.0,12.0),
                new StudentExtraItem("Icecream",new Date(),2.0,50.0),
                new StudentExtraItem("Snacks",new Date(),1.0,3.2),
                new StudentExtraItem("Pineapple",new Date(), 2.0, 24.0),
                new StudentExtraItem("Apple",new Date(),1.0,12.0),
                new StudentExtraItem("Icecream",new Date(),2.0,50.0),
                new StudentExtraItem("Snacks",new Date(),1.0,3.2),
                new StudentExtraItem("Pineapple",new Date(), 2.0, 24.0),
                new StudentExtraItem("Apple",new Date(),1.0,12.0),
                new StudentExtraItem("Icecream",new Date(),2.0,50.0)
        );
        return observableList;
    }

    private ObservableList<StudentMessLeave> getMessLeaves(){
        ObservableList<StudentMessLeave> observableList = FXCollections.observableArrayList(
                new StudentMessLeave(Instant.ofEpochSecond(1506882600).atZone(ZoneId.systemDefault()).toLocalDate(),Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate())
        );
        return observableList;
    }
}
