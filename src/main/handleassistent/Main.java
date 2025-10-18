import Brukerprofiler.*;
import recepies.*;

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


        FileToRecipe ftr = new FileToRecipe();

        try {
            ftr.loadFromCsv("data/oppskrifter.csv");

            // Create search engine with loaded products
            RecipeSearch searchEngine = new RecipeSearch(ftr.getRecipe());
            String userInput = "melk";
            String filter = "null";
            ArrayList<Recipe> recipeMatches = searchEngine.searchByKeyword(userInput, filter);

            for (Recipe r : recipeMatches) {
                System.out.println(r.getTitle());
            }

        }
        catch (IOException  e) {
            System.err.println("Kunne ikke lese filen: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
