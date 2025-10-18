package recepies;

import java.io.IOException;
import java.util.ArrayList;

public class RecipeSearch {
    ArrayList<Recipe> recipes;
    public RecipeSearch() throws IOException {
        FileToRecipe fil = new FileToRecipe();
        fil.loadFromCsv("data/oppskrifter.csv");
        this.recipes = fil.getRecipes();
    }

    public boolean containsIngredient(Recipe r, String ingredient){
        for(int i = 0; i < r.getIngridients().length;i++){
            if(r.getIngridients()[i].toLowerCase().contains(ingredient.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Recipe> getRecipes(String[] ingredienser) {
        ArrayList<Recipe> returListe = new ArrayList<>();
        int funnetIngr = 0;
        for(int i = 0; i< this.recipes.size();i++){
            for(int j = 0; j<ingredienser.length;j++){
                if(this.containsIngredient(this.recipes.get(i), ingredienser[j])) {
                    funnetIngr++;
                    if(funnetIngr == ingredienser.length) {
                        returListe.add(this.recipes.get(i));
                        System.out.println(this.recipes.get(i).getTitle());
                    }
                }
            }
            funnetIngr = 0;
        }
        return returListe;
    }
    public static void main(String[] args) throws IOException {
        RecipeSearch test = new RecipeSearch();

        String[] ingrediensListe = {"agurk"};
        System.out.println(test.recipes.size());

        ArrayList<Recipe> funnetoppskrifter =  test.getRecipes(ingrediensListe);
        System.out.println(funnetoppskrifter.size());

    }
}
