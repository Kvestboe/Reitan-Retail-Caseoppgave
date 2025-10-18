import Brukerprofiler.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileToProduct ftp = new FileToProduct();
        try {
            ftp.loadFromCsv("data/products.csv");

            // Create search engine with loaded products
            ProductSearch searchEngine = new ProductSearch(ftp.getProducts());
            String userInput = "brød";
            String filter = "gluten";
            ArrayList<Product> productMatches = searchEngine.searchByKeyword(userInput, filter);

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
