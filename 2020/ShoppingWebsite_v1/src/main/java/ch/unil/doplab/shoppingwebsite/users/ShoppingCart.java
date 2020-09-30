package ch.unil.doplab.shoppingwebsite.users;

import ch.unil.doplab.shoppingwebsite.items.Drink;
import ch.unil.doplab.shoppingwebsite.items.Food;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class ShoppingCart {

    private int id;
    private static int count = 0;
    private ArrayList<Food> foods;
    private ArrayList<Drink> drinks;
    private double balance = 0.0;

    public ShoppingCart() {
        this.id = ++count;
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
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

    public int getId() {
        return id;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", foods=" + Arrays.toString(foods.toArray()) + ", drinks=" + Arrays.toString(drinks.toArray()) + '}';
    }

}
