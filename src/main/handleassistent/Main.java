import Brukerprofiler.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileToProduct ftp = new FileToProduct();
        try {
            ftp.loadFromCsv("data/products.csv");

            // Create search engine with loaded products
            ProductSearch searchEngine = new ProductSearch(ftp.getProducts());
            String userInput = "brød";
            List<String> filters = Arrays.asList("organic");
            ArrayList<Product> productMatches = searchEngine.searchByKeyword(userInput, filters);

            for (Product p : productMatches) {
                System.out.println(p.getName());
            }

        }
        catch (IOException  e) {
            System.err.println("Kunne ikke lese filen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
