package Brukerprofiler;

public class Product {
    private final String name;
    private final double price;
    private final boolean isVegan;
    private final boolean isGlutenFree;
    private final boolean isLactoseFree;
    public Product(String name, double price, boolean isVegan, boolean isGlutenFree,  boolean isLactoseFree) {
        this.name = name;
        this.price = price;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isLactoseFree = isLactoseFree;
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public boolean isVegan() {return isVegan;}
    public boolean isGlutenFree() {return isGlutenFree;}
    public boolean isLactoseFree() {return isLactoseFree;}

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        answer.append("Name: " + this.name + "\n");
        answer.append(" Price: " + this.price);
        answer.append(" Vegan: " + this.isVegan);
        answer.append(" Gluten free: " + this.isGlutenFree);
        answer.append(" Lactose free: " + this.isLactoseFree);

        return answer.toString();
    }
}
