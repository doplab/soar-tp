package ch.unil.doplab.shoppingwebsite_v3.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class ShoppingCart implements Serializable {

    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private double balance = 0.0;

    public ShoppingCart() {
    }

    public double emptyShoppingCart() {
        foods.clear();
        drinks.clear();
        double tmp = balance;
        balance = 0.0;
        return tmp;
    }

    public double getBalance() {
        return balance;
    }

    public void addAFood(Food food) {
        foods.add(food);
        balance += food.getPrice();
    }

    public void addADrink(Drink drink) {
        drinks.add(drink);
        balance += drink.getPrice();
    }

    public void removeAFood(Food food) {
        foods.remove(food);
        balance -= food.getPrice();
    }

    public void removeADrink(Drink drink) {
        drinks.remove(drink);
        balance -= drink.getPrice();
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.foods);
        hash = 97 * hash + Objects.hashCode(this.drinks);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
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
        final ShoppingCart other = (ShoppingCart) obj;
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.foods, other.foods)) {
            return false;
        }
        if (!Objects.equals(this.drinks, other.drinks)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "\nFoods=" + Arrays.toString(foods.toArray())
                + "\nDrinks=" + Arrays.toString(drinks.toArray()) + '}';
    }

}
