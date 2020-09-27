package ch.unil.doplab.shoppingwebsite.items;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Drink implements Drinkable {

    private int id;
    private String name;
    private double price;
    private boolean hasAcohol;
    private static int count = 0;

    public Drink(String name, double price, boolean hasAcohol) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.hasAcohol = hasAcohol;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Drink other = (Drink) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Drink{" + "id=" + id + ", name=" + name + ", price=" + price + ", hasAcohol=" + hasAcohol + "}";
    }

}
