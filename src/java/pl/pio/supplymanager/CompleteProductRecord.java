package pl.pio.supplymanager;

import javafx.scene.control.Button;

public class CompleteProductRecord implements Comparable<pl.pio.supplymanager.CompleteProductRecord>{
    private String code;
    private DescriptionButton descriptionButton;
    private String category;
    private String production;
    private String name;
    private int quantity;
    private double price;

    public CompleteProductRecord(String code, String description, String category, String production, String name, int quantity, double price) {
        this.code = code;
        this.descriptionButton = new DescriptionButton("Pokaż opis", description);
        this.category = category;
        this.production = production;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public Button getDescriptionButton() {
        return descriptionButton;
    }

    public String getCategory() {
        return category;
    }

    public String getProduction() {
        return production;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals( Object o ) {
        if( o instanceof pl.pio.supplymanager.CompleteProductRecord) {
            pl.pio.supplymanager.CompleteProductRecord os = (pl.pio.supplymanager.CompleteProductRecord)o;
            return Integer.parseInt(os.code) == Integer.parseInt(this.code);
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(pl.pio.supplymanager.CompleteProductRecord cmp2){
        return this.quantity - cmp2.quantity;
    }

    public int compareToQuantity(pl.pio.supplymanager.CompleteProductRecord cmp2){
        return this.quantity - cmp2.quantity;
    }
    public double compareToPrice(pl.pio.supplymanager.CompleteProductRecord cmp2){
        return this.price - cmp2.price;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(code);
    }
}

