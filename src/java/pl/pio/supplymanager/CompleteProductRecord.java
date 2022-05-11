package pl.pio.supplymanager;

public class CompleteProductRecord implements Comparable<CompleteProductRecord>{
    private String code;
    private String description;
    private String category;
    private String production;
    private String name;
    private int quantity;
    private double price;

    public CompleteProductRecord(String code, String description, String category, String production, String name, int quantity, double price) {
        this.code = code;
        this.description = description;
        this.category = category;
        this.production = production;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
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
        if( o instanceof CompleteProductRecord ) {
            CompleteProductRecord os = (CompleteProductRecord)o;
            return Integer.parseInt(os.code) == Integer.parseInt(this.code);
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(CompleteProductRecord cmp2){
        return this.quantity - cmp2.quantity;
    }

    public int compareToQuantity(CompleteProductRecord cmp2){
        return this.quantity - cmp2.quantity;
    }
    public double compareToPrice(CompleteProductRecord cmp2){
        return this.price - cmp2.price;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(code);
    }
}

