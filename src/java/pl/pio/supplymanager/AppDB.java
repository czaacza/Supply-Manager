package pl.pio.supplymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class AppDB {
    ObservableList<CompleteProductRecord> completeProductRecordDB = FXCollections.observableArrayList();
    ObservableList<Product> productsDB = FXCollections.observableArrayList();
    ObservableList<Production> productionDB = FXCollections.observableArrayList();
    ObservableList<Category> categoriesDB = FXCollections.observableArrayList();
    ObservableList<Description> descriptionsDB = FXCollections.observableArrayList();

    public void readProductsFromFile() throws FileNotFoundException {
        int code;
        int descriptionID;
        int categoryID;
        int productionID;
        String name;
        int quantity;
        double price;

        URL url = getClass().getResource("products.txt");
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 7) {
                name = parts[0].trim();
                code = parseInt(parts[1]);
                descriptionID = parseInt(parts[2]);
                categoryID = parseInt(parts[3]);
                productionID = parseInt(parts[4]);
                quantity = parseInt(parts[5]);
                price = parseDouble(parts[6]);

                productsDB.add(new Product(code, descriptionID, categoryID, productionID,name,quantity,price));
                //System.out.printf("Dodano produkt poprawnie (" + name + ")\n");
            }
        }
    }
    public void readProductionsFromFile() throws FileNotFoundException, ParseException {
        int productionID;
        String manufacturer;
        String country;
        Date data;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        URL url = getClass().getResource("productions.txt");
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 4) {
                productionID = parseInt(parts[0]);
                manufacturer = parts[1].trim();
                country = parts[2].trim();
                String dateAsString = parts[3].trim();
                data = formatter.parse(dateAsString);

                productionDB.add(new Production(productionID, manufacturer, country, data));
                //System.out.printf("Dodano producenta poprawnie (" + manufacturer + ")\n");
            }
        }
    }
    public void readCategoriesFromFile() throws FileNotFoundException {
        int categoryID;
        String category;

        URL url = getClass().getResource("categories.txt");
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 2) {
                categoryID = parseInt(parts[0]);
                category = parts[1].trim();

                categoriesDB.add(new Category(categoryID, category));
                //System.out.printf("Dodano kategorię poprawnie (" + category + ")\n");
            }
        }
    }
    public void readDescriptionsFromFile() throws FileNotFoundException {
        int descID;
        String desc;

        URL url = getClass().getResource("descriptions.txt");
        assert url != null;
        File file = new File(url.getPath());
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\t");

            if (parts.length == 2) {
                descID = parseInt(parts[0]);
                desc = parts[1].trim();

                descriptionsDB.add(new Description(descID, desc));
                //System.out.printf("Dodano opis poprawnie (" + desc.substring(0, 10) + "...)\n");
            }
        }
    }

    private String getCategoryAsID(int ID){
        Category cat = categoriesDB.get(ID-1);
        return cat.category;
    }
    private String getDiscriptionAsID(int ID){
        Description des = descriptionsDB.get(ID-1);
        return des.desc;

    }
    private String getProductionAsID(int ID){
        Production pro = productionDB.get(ID-1);
        return pro.getManufacturer();
    }
    public void createCompleteProductDB(){
        int size = productsDB.size();
        for(int currentIndex = 0; currentIndex < size; currentIndex++){
            String code;
            String description;
            String category;
            String production;
            String name;
            int quantity;
            double price;

            Product currentProduct = productsDB.get(currentIndex);

            code = String.valueOf(currentProduct.getCode());
            name = currentProduct.getName();
            quantity = currentProduct.getQuantity();
            price = currentProduct.getPrice();

            category = getCategoryAsID(currentProduct.getCategoryID());
            production = getProductionAsID(currentProduct.getProductionID());
            description = getDiscriptionAsID(currentProduct.getDescriptionID());


            completeProductRecordDB.add(new CompleteProductRecord(code,description,category,production,name,quantity,price));
        }
    }

    private ObservableList<Product> getProductsDB() {
        return productsDB;
    }

    private ObservableList<Production> getProductionDB() {
        return productionDB;
    }

    private ObservableList<Category> getCategoriesDB() {
        return categoriesDB;
    }

    private ObservableList<Description> getDescriptionsDB() {
        return descriptionsDB;
    }
    public ObservableList<CompleteProductRecord> getCompleteProductRecordDB() {
        return completeProductRecordDB;
    }

}
