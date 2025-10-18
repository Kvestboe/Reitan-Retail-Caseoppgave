package Brukerprofiler;
import java.util.ArrayList;


public class Product {
    private final int productId;
    private final long gtin;
    private final String name;
    private final String description;
    private final double price;
    private final double pricePerUnit;
    private final String unit;
    private final ArrayList<String> allergens;
    private final String carbonFootprintGram;
    private final boolean organic;
    public Product(int productId, long gtin, String name, String description, double price, double pricePerUnit, String unit, ArrayList<String> allergens, String carbonFootprintGram, boolean organic) {
        this.productId = productId;
        this.gtin = gtin;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
        this.allergens = allergens;
        this.carbonFootprintGram = carbonFootprintGram;
        this.organic = organic;
    }

    //Getters
    public int getProductId() { return productId; }
    public long getGtin() { return gtin; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public double getPricePerUnit() { return pricePerUnit; }
    public String getUnit() { return unit; }
    public ArrayList<String> getAllergens() { return allergens; }
    public String getCarbonFootprintGram() { return carbonFootprintGram; }
    public boolean getOrganic() { return organic; }
}
