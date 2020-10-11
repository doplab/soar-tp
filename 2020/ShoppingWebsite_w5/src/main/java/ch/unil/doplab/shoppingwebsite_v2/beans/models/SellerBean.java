package ch.unil.doplab.shoppingwebsite_v2.beans.models;

import ch.unil.doplab.shoppingwebsite_v2.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "sellerBean")
@SessionScoped
public class SellerBean extends User implements Serializable {

    private boolean verified;
    private ArrayList<FoodBean> foods = new ArrayList<>();
    private ArrayList<DrinkBean> drinks = new ArrayList<>();

    public SellerBean() {
    }

    public boolean isVerified() {
        return verified;
    }

    public ArrayList<DrinkBean> getDrinks() {
        return drinks;
    }

    public ArrayList<FoodBean> getFoods() {
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
