package ch.unil.doplab.shoppingwebsite.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Food implements Edible {

    private String name;
    private double price;
    private boolean hasMeat;
    private ArrayList<String> ingredients;

    private Food(String name, double price, boolean hasMeat) {
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + (this.hasMeat ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.ingredients);
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
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.hasMeat != other.hasMeat) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Food{" + "name=" + name + ", price=" + price + ", hasMeat=" + hasMeat + ", ingredients=" + Arrays.toString(ingredients.toArray()) + '}';
    }
}
