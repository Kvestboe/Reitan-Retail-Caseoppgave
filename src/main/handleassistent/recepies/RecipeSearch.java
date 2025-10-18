package recepies;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecipeSearch {
    private final ArrayList<Recipe> recipes;

    public RecipeSearch(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    private boolean matchesKeyword(Recipe r, String lowerKeyword) {
        return r.getTitle().toLowerCase().contains(lowerKeyword) ||
                r.getIngridients().toLowerCase().contains(lowerKeyword);
    }

    public ArrayList<Recipe> serchByKeyword(Recipe keyword, String filter) {
        ArrayList<Recipe> matches = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Recipe p : ) {
            if (!matchesKeyword(r, lowerKeyword)) continue;
            {
            }

            if (filter == null) {
                matches.add(r);
            } else {
                switch (filter.toLowerCase()) {
                    case "laktose":
                        if (r.getAllergens().contains("laktose")) matches.add(r);
                        break;
                    case "gluten":
                        if (!r.getAllergens().contains("gluten")) matches.add(r);
                        break;
                }
                return matches;
            }
        }
    }
}
