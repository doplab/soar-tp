package ch.unil.doplab.shoppingwebsite_v2.models;

import ch.unil.doplab.shoppingwebsite_v2.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Seller extends User implements Serializable {

    private boolean verified;
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();

    public Seller() {
    }

    public boolean isVerified() {
        return verified;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String productsToString() {
        return "Foods: " + Arrays.toString(foods.toArray()) + "\nDrinks: " + Arrays.toString(drinks.toArray());
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nVerified: " + this.isVerified()
                + "\nFoods: " + Arrays.toString(foods.toArray())
                + "\nDrinks: " + Arrays.toString(drinks.toArray());
    }

}
