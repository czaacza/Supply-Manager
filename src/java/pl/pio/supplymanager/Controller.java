package pl.pio.supplymanager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private TableView<CompleteProductRecord> productsTable;
    @FXML private TableColumn<CompleteProductRecord, String> colName;
    @FXML private TableColumn<CompleteProductRecord, Integer> colQuantity;
    @FXML private TableColumn<CompleteProductRecord, Integer> colCode;
    @FXML private TableColumn<CompleteProductRecord, String> colCategory;
    @FXML private TableColumn<CompleteProductRecord, String> colProducer;
    @FXML private TableColumn<CompleteProductRecord, Double> colPrice;
    @FXML private TableColumn<CompleteProductRecord, Button> colDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Integer>("quantity"));
        colCode.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Integer>("code"));
        colCategory.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("category"));
        colProducer.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("production"));
        colPrice.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Double>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, Button>("descriptionButton"));
        colDescription.setStyle("-fx-alignment: CENTER;");

        AppDB appDB = new AppDB();
        try {
            appDB.readProductsFromFile("products.txt");
            appDB.readProductionsFromFile("productions.txt");
            appDB.readCategoriesFromFile("categories.txt");
            appDB.readDescriptionsFromFile("descriptions.txt");
            appDB.createCompleteProductDB(appDB.getCompleteProductRecordDB(), appDB.getProductsDB());
        } catch (Exception e) {
            e.printStackTrace();
        }
        productsTable.setItems(appDB.getCompleteProductRecordDB());
    }
}
