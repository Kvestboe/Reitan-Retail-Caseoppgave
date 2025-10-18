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
                        fields[0],                      // productId
                        fields[1],                      // gtin
                        fields[2],                      // name
                        fields[3],                      // description
                        fields[4],  // price
                        fields[5],  // pricePerUnit
                        fields[6],                      // unit
                        fields[7],                      // allergens
                        fields[8],    // carbonFootprintGram
                        fields[9] // organic
                );

                products.add(p);
            }
        }
    }

    public ArrayList<Product> getProducts() { return products; }
}
