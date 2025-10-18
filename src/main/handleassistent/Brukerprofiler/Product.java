package Brukerprofiler;


public class Product {
    private final String productId;
    private final String gtin;
    private final String name;
    private final String description;
    private final String price;
    private final String pricePerUnit;
    private final String unit;
    private final String allergens;
    private final String carbonFootprintGram;
    private final String organic;
    public Product(String productId, String gtin, String name, String description, String price, String pricePerUnit, String unit, String allergens, String carbonFootprintGram, String organic) {
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
    public String getProductId() {return productId;}
    public String getGtin() {return gtin;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getPrice() {return price;}
    public String getPricePerUnit() {return pricePerUnit;}
    public String getUnit() {return unit;}
    public String getAllergens() {return allergens;}
    public String getCarbonFootprintGram() {return carbonFootprintGram;}
    public String getOrganic() {return organic;}
}
