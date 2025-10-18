package Brukerprofiler;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch {

    private final ArrayList<Product> products;

    // Konstruktør
    public ProductSearch(ArrayList<Product> products) {
        this.products = products;
    }

    // Hjelpemetode
    private boolean matchesKeyword(Product p, String lowerKeyword) {
        return p.getName().toLowerCase().contains(lowerKeyword) ||
                p.getDescription().toLowerCase().contains(lowerKeyword);
    }

    // Søker etter produkter innen en bevisst kategori (filter)
    public ArrayList<Product> searchByKeyword(String keyword, String filter) {
        ArrayList<Product> matches = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Product p : products) {
            if (!matchesKeyword(p, lowerKeyword)) continue;

            if (filter == null) {
                matches.add(p);
            } else {
                switch (filter.toLowerCase()) {
                    case "laktose":
                        if (p.getAllergens().contains("laktose")) matches.add(p);
                        break;
                    case "gluten":
                        if (!p.getAllergens().contains("gluten")) matches.add(p);
                        break;
                }
            }
        }
        return matches;
        /*
        ArrayList<Product> matches = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(lowerKeyword) || p.getDescription().toLowerCase().contains(lowerKeyword)) {
                matches.add(p);
            }
        }
        return matches;
         */
    }
}
