package com.falalurahman.sacmessapp.addExtras;

import com.falalurahman.sacmessapp.Pojo.ExtraItem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class AddExtrasController implements Initializable{

    @FXML
    private TableView<ExtraItem> extraTable;

    @FXML
    private TableColumn<ExtraItem,Number> indexCol;

    @FXML
    private TableColumn<ExtraItem,String> codeCol;

    @FXML
    private TableColumn<ExtraItem,String> nameCol;

    @FXML
    private TableColumn<ExtraItem,Double> priceCol;

    @FXML
    private TableColumn<ExtraItem,ExtraItem> deleteCol;

    @FXML
    private JFXTextField codeEdit;

    @FXML
    private JFXTextField nameEdit;

    @FXML
    private JFXTextField priceEdit;

    @FXML
    private JFXButton addItem;

    private ObservableList<ExtraItem> allExtraItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        indexCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(extraTable.getItems().indexOf(column.getValue()) + 1 ));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        codeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        codeCol.setOnEditCommit(row -> row.getTableView().getItems().get(row.getTablePosition().getRow()).setItemCode(row.getNewValue()));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(row -> row.getTableView().getItems().get(row.getTablePosition().getRow()).setName(row.getNewValue()));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        priceCol.setOnEditCommit(row -> row.getTableView().getItems().get(row.getTablePosition().getRow()).setPrice(row.getNewValue()));
        deleteCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>( column.getValue() ));
        deleteCol.setCellFactory(param -> new TableCell<ExtraItem,ExtraItem>(){
            private final JFXButton deleteButton = new JFXButton("Delete");

            @Override
            protected void updateItem(ExtraItem item, boolean empty) {
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

        addItem.setOnAction(event -> allExtraItems.add(new ExtraItem(codeEdit.getText(),nameEdit.getText(),Double.parseDouble(priceEdit.getText()))));

    }

    private ObservableList<ExtraItem> getExtraItems(){
        ObservableList<ExtraItem> observableList = FXCollections.observableArrayList(
                new ExtraItem("123","Snacks",3.2),
                new ExtraItem("124","Pineapple",12.0),
                new ExtraItem("125","Apple",5.0),
                new ExtraItem("126","orange",6.0)
        );
        return observableList;
    }
}
