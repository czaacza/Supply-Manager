package pl.pio.supplymanager;

public class Product implements Comparable<Product>{
    private int code;
    private int descriptionID;
    private int categoryID;
    private int productionID;
    private String name;
    private int quantity;
    private double price;

    public Product(int code, int descriptionID, int categoryID, int productionID, String name, int quantity, double price) {
        this.code = code;
        this.descriptionID = descriptionID;
        this.categoryID = categoryID;
        this.productionID = productionID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public int getCode() {
        return code;
    }

    public int getDescriptionID() {
        return descriptionID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getProductionID() {
        return productionID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals( Object o ) {
        if( o instanceof Product ) {
            Product os = (Product)o;
            return os.code == this.code;
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(Product product2){
        return this.quantity - product2.quantity;
    }

    public int compareToQuantity(Product product2){
        return this.quantity - product2.quantity;
    }
    @Override
    public int hashCode() {
        return code;
    }
    public double compareToPrice(Product product2){
        return this.price - product2.price;
    }
}
