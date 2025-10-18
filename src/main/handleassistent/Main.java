import Brukerprofiler.FileToProduct;
import Brukerprofiler.Inventory;
import Brukerprofiler.Product;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileToProduct ftp = new FileToProduct();
        try {
            ftp.loadFromCsv("data/products.csv");

            // Create search engine with loaded products
            ProductSearch searchEngine = new ProductSearch(ftp.getProducts());

            // Example search
            String userInput = "hvete";
            ArrayList<Product> productMatches = searchEngine.searchByKeyword(userInput);

            for (Product p : productMatches) {
                System.out.println(p.getName());
            }

        }
        catch (IOException  e) {
            System.err.println("Kunne ikke lese filen: " + e.getMessage());
            e.printStackTrace();
        }

        // Testing av søkefunksjon
        /*
        ArrayList<Product> productMatches = new ArrayList<>();
        String userInput = "hvete";
        System.out.println();
        for (Product p : ftp.getProducts()) {
            if (p.getName().toLowerCase().contains(userInput) || p.getDescription().toLowerCase().contains(userInput)) {
                productMatches.add(p);
            }
        }

        for (Product p : productMatches) {
            System.out.println(p.getName());
        }
        */
    }
}
