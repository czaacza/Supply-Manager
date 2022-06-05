package pl.pio.supplymanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private TableView<CompleteProductRecord> productsTable;
    @FXML private TableColumn<CompleteProductRecord, Button> colName;
    @FXML private TableColumn<CompleteProductRecord, Integer> colQuantity;
    @FXML private TableColumn<CompleteProductRecord, Integer> colCode;
    @FXML private TableColumn<CompleteProductRecord, String> colCategory;
    @FXML private TableColumn<CompleteProductRecord, String> colProducer;
    @FXML private TableColumn<CompleteProductRecord, Double> colPrice;
    @FXML private TableColumn<CompleteProductRecord, Button> colDescription;
    @FXML private TableColumn<CompleteProductRecord, CheckBox> colSelect;

    @FXML private Button saveButton;
    @FXML private Button addNewItem;

    private AppDB appDB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, Button>("changeProductNameButton"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Integer>("quantity"));
        colCode.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Integer>("code"));
        colCategory.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("category"));
        colProducer.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,String>("production"));
        colPrice.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord,Double>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, Button>("descriptionButton"));
        colDescription.setStyle("-fx-alignment: CENTER;");
        colSelect.setCellValueFactory(new PropertyValueFactory<CompleteProductRecord, CheckBox>("select"));
        colName.setStyle("-fx-alignment: CENTER;");

        appDB = new AppDB();
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
        
        saveButton.setOnAction(this::onSaveButtonClick);
        addNewItem.setOnAction(this::onAddNewItemButtonClick);
    }

    @FXML
    public void onSaveButtonClick(ActionEvent e) {
        AppDBSaver appDBSaver = new AppDBSaver(appDB);
        try {
            appDBSaver.saveProductsToFile("products.txt");
            appDBSaver.saveProductionsToFile("productions.txt");
            appDBSaver.saveCategoriesToFile("categories.txt");
            appDBSaver.saveDescriptionsToFile("descriptions.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onAddNewItemButtonClick(ActionEvent e) {
        ProductAdder productAdder = new ProductAdder(appDB);
        productAdder.addNewProduct();
    }
}
