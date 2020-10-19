package ch.unil.doplab.shoppingwebsite_v3.models;

import ch.unil.doplab.shoppingwebsite_3.Edible;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "foodBean")
@SessionScoped
public class FoodBean implements Serializable, Edible {

    private String name;
    private double price;
    private boolean hasMeat;
    private ArrayList<String> ingredients = new ArrayList<>();

    public FoodBean() {
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

    public void setHasMeat(boolean hasMeat) {
        this.hasMeat = hasMeat;
    }
    
    public boolean getHasMeat() {
        return containsMeat();
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
        final FoodBean other = (FoodBean) obj;
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
        return "Food{"
                + "\nName=" + name
                + "\nPrice=" + price
                + "\nHasMeat=" + hasMeat
                + "\nIngredients=" + Arrays.toString(ingredients.toArray()) + '}';
    }
}
