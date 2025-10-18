package Brukerprofiler;
import java.util.ArrayList;

public class Inventory {

   public ArrayList<String> varer = new ArrayList<>();

    public ArrayList<String> getVarer() {
        return varer;
    }


    public void addVarer(String vare) {
        System.out.println("Added  " + vare + " to Fridge");
        this.varer.add(vare);
    }
}
