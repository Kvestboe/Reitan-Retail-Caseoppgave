package Brukerprofiler;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch {

    private final ArrayList<Product> products;

    // Konstruktør
    public ProductSearch(ArrayList<Product> products) {
        this.products = products;
    }


    public ArrayList<Product> searchByKeyword(String keyword) {
        ArrayList<Product> matches = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(lowerKeyword) ||
                    p.getDescription().toLowerCase().contains(lowerKeyword)) {
                matches.add(p);
            }
        }
        //returnerer
        return matches;
    }
}
