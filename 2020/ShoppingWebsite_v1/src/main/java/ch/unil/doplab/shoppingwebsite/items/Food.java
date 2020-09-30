package ch.unil.doplab.shoppingwebsite.items;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Food implements Edible {

    private int id;
    private static int count = 0;
    private String name;
    private double price;
    private boolean hasMeat;
    private ArrayList<String> ingredients;

    private Food(String name, double price, boolean hasMeat) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.hasMeat = hasMeat;
        ingredients = new ArrayList<>();
    }

    public Food(String name, double price, boolean hasMeat, ArrayList<String> ingredientList) {
        this(name, price, hasMeat);
        ingredients.addAll(ingredientList);
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean containsMeat() {
        return hasMeat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Food other = (Food) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", price=" + price + ", hasMeat=" + hasMeat + ", ingredients=" + Arrays.toString(ingredients.toArray()) + '}';
    }
}
