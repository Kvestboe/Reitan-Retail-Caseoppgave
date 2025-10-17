import Brukerprofiler.Inventory;
import Brukerprofiler.Product;

public class Main {
    Product product = new Product();
    public static void main(String[] args) {
        Inventory f = new Inventory();
        f.addVarer("Poteter");
        f.addVarer("Epler");
        for (String vare : f.getVarer()) {
            System.out.println(vare);
        }

    }
}
