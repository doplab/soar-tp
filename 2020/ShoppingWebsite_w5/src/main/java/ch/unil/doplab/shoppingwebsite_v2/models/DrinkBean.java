package ch.unil.doplab.shoppingwebsite_v2.models;

import ch.unil.doplab.shoppingwebsite_v2.Drinkable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "drinkBean")
@SessionScoped
public class DrinkBean implements Serializable, Drinkable {

    private String name;
    private double price;
    private boolean hasAcohol;

    public DrinkBean() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean containsAlcohol() {
        return hasAcohol;
    }

    public void setHasAcohol(boolean hasAcohol) {
        this.hasAcohol = hasAcohol;
    }
    
    public boolean getHasAlcohol() {
        return containsAlcohol();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 31 * hash + (this.hasAcohol ? 1 : 0);
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
        final DrinkBean other = (DrinkBean) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.hasAcohol != other.hasAcohol) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Drink{"
                + "\nName=" + name
                + "\nPrice=" + price
                + "\nHasAcohol=" + hasAcohol + "}";
    }

}
