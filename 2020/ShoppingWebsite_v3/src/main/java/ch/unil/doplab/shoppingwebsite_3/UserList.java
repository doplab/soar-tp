package ch.unil.doplab.shoppingwebsite_3;

import ch.unil.doplab.shoppingwebsite_v3.models.Admin;
import ch.unil.doplab.shoppingwebsite_v3.models.Buyer;
import ch.unil.doplab.shoppingwebsite_v3.models.Drink;
import ch.unil.doplab.shoppingwebsite_v3.models.Food;
import ch.unil.doplab.shoppingwebsite_v3.models.Seller;
import ch.unil.doplab.shoppingwebsite_v3.models.User;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class UserList {

    private ArrayList<User> users;
    private ArrayList<Admin> admins;
    private ArrayList<Buyer> buyers;
    private ArrayList<Seller> sellers;

    private static UserList singletonInstance = null;

    private UserList() {
        users = new ArrayList<>();
        admins = new ArrayList<>();
        buyers = new ArrayList<>();
        sellers = new ArrayList<>();
        addTheFirstUsers();
    }

    public static UserList getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new UserList();
        }
        return singletonInstance;
    }

    private void addTheFirstUsers() {
        // admin
        Admin admin = new Admin();
        admin.setUsername("lisa");
        admin.setFirstName("lisa");
        admin.setLastName("simpson");
        admin.setEmail("lisa@simpson.com");
        admin.setPassword("1234");
        users.add(admin);
        admins.add(admin);
        // buyer
        Buyer buyer = new Buyer();
        buyer.setUsername("marge");
        buyer.setFirstName("marge");
        buyer.setLastName("simpson");
        buyer.setEmail("marge@simpson.com");
        buyer.setPassword("1234");
        users.add(buyer);
        buyers.add(buyer);
        // seller
        Seller seller = new Seller();
        seller.setUsername("Barty's");
        seller.setFirstName("bart");
        seller.setLastName("simpson");
        seller.setEmail("bart@simpson.com");
        seller.setPassword("1234");
        users.add(seller);
        sellers.add(seller);
        // add foods and drinks to the seller's shop
        // food - pasta
        Food pasta = new Food();
        pasta.setName("Pasta");
        pasta.setPrice(15.0);
        pasta.setHasMeat(false);
        pasta.getIngredients().add("spaghetti");
        pasta.getIngredients().add("pesto sauce");
        pasta.getIngredients().add("parmigiano");
        seller.getFoods().add(pasta);
        // food - pizza
        Food pizza = new Food();
        pizza.setName("Pizza");
        pizza.setPrice(12.0);
        pizza.setHasMeat(false);
        pizza.getIngredients().add("dough");
        pizza.getIngredients().add("tomato sauce");
        pizza.getIngredients().add("mozarella");
        seller.getFoods().add(pizza);
        // food - chickenCurry
        Food chickenCurry = new Food();
        chickenCurry.setName("Chicken Curry");
        chickenCurry.setPrice(18.0);
        chickenCurry.setHasMeat(true);
        chickenCurry.getIngredients().add("chicken");
        chickenCurry.getIngredients().add("curry sauce");
        seller.getFoods().add(chickenCurry);
        // drink - water
        Drink water = new Drink();
        water.setName("Water");
        water.setPrice(1.0);
        water.setHasAcohol(false);
        seller.getDrinks().add(water);
        // drink - ice tea
        Drink iceTea = new Drink();
        iceTea.setName("Ice Tea");
        iceTea.setPrice(2.0);
        iceTea.setHasAcohol(false);
        seller.getDrinks().add(iceTea);
        // drink = vodka
        Drink vodka = new Drink();
        vodka.setName("Vodka");
        vodka.setPrice(5.0);
        vodka.setHasAcohol(true);
        seller.getDrinks().add(vodka);
    }

    public void addAnAdmin(Admin admin) {
        users.add(admin);
        admins.add(admin);
    }

    public void addABuyer(Buyer buyer) {
        users.add(buyer);
        buyers.add(buyer);
    }

    public void addASeller(Seller seller) {
        users.add(seller);
        sellers.add(seller);
    }

    public void removeAnAdmin(User user) {
        users.remove(user);
        admins.remove(user);
    }

    public void removeASeller(User user) {
        users.remove(user);
        sellers.remove(user);
    }

    public void removeABuyer(User user) {
        users.remove(user);
        buyers.remove(user);
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
