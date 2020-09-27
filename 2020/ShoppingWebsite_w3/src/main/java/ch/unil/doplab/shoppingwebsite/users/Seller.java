package ch.unil.doplab.shoppingwebsite.users;

import ch.unil.doplab.shoppingwebsite.items.Drink;
// TODO/Food : uncomment
//import ch.unil.doplab.shoppingwebsite.items.Food;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Seller extends User {

    private boolean verified;
// TODO/Food : uncomment
//    private ArrayList<Food> foods;
    private ArrayList<Drink> drinks;

    public Seller(String shopName, String firstName, String lastName, String email, String password) {
        super(shopName, firstName, lastName, email, password);
        this.verified = false;
// TODO/Food : uncomment
//        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public boolean isVerified() {
        return verified;
    }
    
    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

// TODO/Food : uncomment
//    public ArrayList<Food> getFoods() {
//        return foods;
//    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

// TODO/Food : uncomment
    public String productsToString() {
        return /*"Foods: " + Arrays.toString(foods.toArray()) +*/ "\nDrinks: " + Arrays.toString(drinks.toArray()) + ".";
    }
    
// TODO/Food : uncomment
    @Override
    public String toString() {
        return super.toString() + "\nVerified: " + this.isVerified() + /* "\nFoods: " + Arrays.toString(foods.toArray()) +*/ "\nDrinks: " + Arrays.toString(drinks.toArray());
    }

}
