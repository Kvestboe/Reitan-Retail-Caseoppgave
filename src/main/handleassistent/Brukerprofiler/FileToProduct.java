package Brukerprofiler;

import java.io.*;
import java.util.*;

public class FileToProduct {
    private ArrayList<Product> products = new ArrayList<>();

    public void loadFromCsv(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                // Split on comma, respecting simple CSV (quotes not handled here)
                String[] fields = line.split(",");

                Product p = new Product(
                        Integer.parseInt(fields[0]),    // productId
                        Long.parseLong(fields[1]),    // gtin
                        fields[2],                      // name
                        fields[3],                      // description
                        Double.parseDouble(fields[4]),  // price
                        Double.parseDouble(fields[5]),  // pricePerUnit
                        fields[6],                      // unit
                        fields[7],                      // allergens
                        fields[8],                      // carbonFootprintGram
                        Boolean.parseBoolean(fields[9]) // organic
                );

                products.add(p);
            }
        }
    }

    public ArrayList<Product> getProducts() { return products; }
}
