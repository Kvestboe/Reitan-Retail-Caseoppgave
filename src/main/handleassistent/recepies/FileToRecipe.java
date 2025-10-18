package recepies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileToRecipe {
    private ArrayList<Recipe> recipes = new ArrayList<>();


    public void loadFromCsv(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                // Split on comma, respecting simple CSV (quotes not handled here)
                String[] fields = line.split(",");

                Recipe p = new Recipe(
                        fields[0],                      // title
                        fields[1].split(";"),                      // ingredients
                        fields[2]                       // url
                );

                recipes.add(p);
            }
        }
    }

    public ArrayList<Recipe> getRecipes() { return recipes; }
}
