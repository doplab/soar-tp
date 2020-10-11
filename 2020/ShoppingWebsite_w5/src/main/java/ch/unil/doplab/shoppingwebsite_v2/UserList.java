package ch.unil.doplab.shoppingwebsite_v2;

import ch.unil.doplab.shoppingwebsite_v2.beans.models.AdminBean;
import ch.unil.doplab.shoppingwebsite_v2.beans.models.BuyerBean;
import ch.unil.doplab.shoppingwebsite_v2.beans.models.DrinkBean;
import ch.unil.doplab.shoppingwebsite_v2.beans.models.FoodBean;
import ch.unil.doplab.shoppingwebsite_v2.beans.models.SellerBean;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class UserList {

    private ArrayList<User> users;
    private ArrayList<AdminBean> admins;
    private ArrayList<BuyerBean> buyers;
    private ArrayList<SellerBean> sellers;

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
        AdminBean admin = new AdminBean();
        admin.setUsername("lisa");
        admin.setFirstName("lisa");
        admin.setLastName("simpson");
        admin.setEmail("lisa@simpson.com");
        admin.setPassword("1234");
        users.add(admin);
        admins.add(admin);
        // buyer
        BuyerBean buyer = new BuyerBean();
        buyer.setUsername("marge");
        buyer.setFirstName("marge");
        buyer.setLastName("simpson");
        buyer.setEmail("marge@simpson.com");
        buyer.setPassword("1234");
        users.add(buyer);
        buyers.add(buyer);
        // seller
        SellerBean seller = new SellerBean();
        seller.setUsername("Barty's");
        seller.setFirstName("bart");
        seller.setLastName("simpson");
        seller.setEmail("bart@simpson.com");
        seller.setPassword("1234");
        users.add(seller);
        sellers.add(seller);
        // add foods and drinks to the seller's shop
        // food - pasta
        FoodBean pasta = new FoodBean();
        pasta.setName("Pasta");
        pasta.setPrice(15.0);
        pasta.setHasMeat(false);
        pasta.getIngredients().add("spaghetti");
        pasta.getIngredients().add("pesto sauce");
        pasta.getIngredients().add("parmigiano");
        seller.getFoods().add(pasta);
        // food - pizza
        FoodBean pizza = new FoodBean();
        pizza.setName("Pizza");
        pizza.setPrice(12.0);
        pizza.setHasMeat(false);
        pizza.getIngredients().add("dough");
        pizza.getIngredients().add("tomato sauce");
        pizza.getIngredients().add("mozarella");
        seller.getFoods().add(pizza);
        // food - chickenCurry
        FoodBean chickenCurry = new FoodBean();
        chickenCurry.setName("Chicken Curry");
        chickenCurry.setPrice(18.0);
        chickenCurry.setHasMeat(true);
        chickenCurry.getIngredients().add("chicken");
        chickenCurry.getIngredients().add("curry sauce");
        seller.getFoods().add(chickenCurry);
        // drink - water
        DrinkBean water = new DrinkBean();
        water.setName("name");
        water.setPrice(1.0);
        water.setHasAcohol(false);
        seller.getDrinks().add(water);
        // drink - ice tea
        DrinkBean iceTea = new DrinkBean();
        iceTea.setName("Ice Tea");
        iceTea.setPrice(2.0);
        iceTea.setHasAcohol(false);
        seller.getDrinks().add(iceTea);
        // drink = vodka
        DrinkBean vodka = new DrinkBean();
        vodka.setName("Vodka");
        vodka.setPrice(5.0);
        vodka.setHasAcohol(true);
        seller.getDrinks().add(vodka);
    }

    public void addAnAdmin(AdminBean admin) {
        users.add(admin);
        admins.add(admin);
    }

    public void addABuyer(BuyerBean buyer) {
        users.add(buyer);
        buyers.add(buyer);
    }

    public void addASeller(SellerBean seller) {
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

    public ArrayList<AdminBean> getAdmins() {
        return admins;
    }

    public ArrayList<BuyerBean> getBuyers() {
        return buyers;
    }

    public ArrayList<SellerBean> getSellers() {
        return sellers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
