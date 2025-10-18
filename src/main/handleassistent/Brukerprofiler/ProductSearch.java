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
    public ArrayList<Product> searchByKeyword(String keyword, List<String> filters) {
        ArrayList<Product> matches = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Product p : products) {
            if (!matchesKeyword(p, lowerKeyword)) continue;

            boolean passesFilters = true;

            if (filters != null && !filters.isEmpty()) {
                for (String f : filters) {
                    String lowerFilter = f.toLowerCase();

                    // Example: exclude products containing this allergen
                    if (p.getAllergens().contains(lowerFilter)) {
                        passesFilters = false;
                        break;
                    }
                }
            }

            if (passesFilters) {
                matches.add(p);
            }
        }
        return matches;
    }
}
