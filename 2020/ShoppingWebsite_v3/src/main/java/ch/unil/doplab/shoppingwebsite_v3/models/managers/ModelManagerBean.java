package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import ch.unil.doplab.shoppingwebsite_v3.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v3.models.Admin;
import ch.unil.doplab.shoppingwebsite_v3.models.Buyer;
import ch.unil.doplab.shoppingwebsite_v3.models.Drink;
import ch.unil.doplab.shoppingwebsite_v3.models.Food;
import ch.unil.doplab.shoppingwebsite_v3.models.Seller;
import ch.unil.doplab.shoppingwebsite_v3.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.EJB;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "modelManager")
@SessionScoped
public class ModelManagerBean implements Serializable {

    @EJB
    ModelManagerSessionBeanRemote mmsbr;

    private String username = "";
    private String password = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";

    private String shopName = "";

    private double amount;

    private String foodName = "";
    private double foodPrice = 0;
    private String hasMeat = "";
    private String ingredientsBefore = "";

    private String drinkName = "";
    private double drinkPrice = 0;
    private String hasAlcohol = "";

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getShopName() {
        return shopName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public String getIngredientsBefore() {
        return ingredientsBefore;
    }

    public String getHasAlcohol() {
        return hasAlcohol;
    }

    public String getHasMeat() {
        return hasMeat;
    }

    public double getAmount() {
        return amount;
    }

    public User getCurrentUser() {
        return mmsbr.getCurrentUser();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setHasAlcohol(String hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

    public void setHasMeat(String hasMeat) {
        this.hasMeat = hasMeat;
    }

    public void setIngredientsBefore(String ingredientsBefore) {
        this.ingredientsBefore = ingredientsBefore;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
//</editor-fold>

    public Seller retrieveCurrentSeller() {
        return (Seller) mmsbr.getCurrentUser();
    }

    public Buyer retrieveCurrentBuyer() {
        return (Buyer) mmsbr.getCurrentUser();
    }

    public String userLogsIn() {
        return mmsbr.userLogsIn(username, password);
    }

    public String userLogsout() {
        return mmsbr.userLogsout();
    }

    public String createAnAdmin() {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPassword(password);
        return mmsbr.createAnAdmin(admin);
    }

    public String createABuyer() {
        Buyer buyer = new Buyer();
        buyer.setUsername(username);
        buyer.setFirstName(firstName);
        buyer.setLastName(lastName);
        buyer.setEmail(email);
        buyer.setPassword(password);
        return mmsbr.createABuyer(buyer);
    }

    public String createASeller() {
        Seller seller = new Seller();
        seller.setUsername(username);
        seller.setFirstName(firstName);
        seller.setLastName(lastName);
        seller.setEmail(email);
        seller.setPassword(password);
        seller.setVerified(false);
        return mmsbr.createASeller(seller);
    }

    public String removeAnAdmin() {
        return mmsbr.removeAnAdmin(username);
    }

    public String removeABuyer() {
        return mmsbr.removeABuyer(username);
    }

    public String removeASeller() {
        return mmsbr.removeASeller(username);
    }

    public String verifyAShop() {
        return mmsbr.verifyAShop(shopName);
    }

    public Seller findSellerByShopName() throws DoesNotExistException {
        return mmsbr.findSellerByShopName(shopName);
    }

    public String addADrinkToShop() {
        Drink drink = new Drink();
        drink.setName(drinkName);
        drink.setPrice(drinkPrice);
        drink.setHasAcohol(hasAlcohol.equals("true") ? true : false);
        return mmsbr.addADrinkToShop(drink);
    }

    public String addAFoodToShop() {
        Food food = new Food();
        food.setName(foodName);
        food.setPrice(foodPrice);
        food.setHasMeat(hasMeat.equals("true") ? true : false);
        food.getIngredients().addAll(Arrays.asList(ingredientsBefore.split(",")));
        return mmsbr.addAFoodToShop(food);
    }

    public String removeADrinkFromShop() {
        return mmsbr.removeADrinkFromShop(drinkName);
    }

    public String removeAFoodFromShop() {
        return mmsbr.removeAFoodFromShop(foodName);
    }

    public String addADrinkToShoppingCart() {
        return mmsbr.addADrinkToShoppingCart(drinkName, shopName);
    }

    public String addAFoodToShoppingCart() {
        return mmsbr.addAFoodToShoppingCart(foodName, shopName);
    }

    public String removeADrinkFromShoppingCart() {
        return mmsbr.removeADrinkFromShoppingCart(drinkName);
    }

    public String removeAFoodFromShoppingCart() {
        return mmsbr.removeAFoodFromShoppingCart(foodName);
    }

    public String completePurchasement() {
        return mmsbr.completePurchasement();
    }

    public ArrayList<User> retreiveUsers() {
        return mmsbr.getAllUsers();
    }

    public ArrayList<Admin> retreiveAdmins() {
        return mmsbr.getAllAdmins();
    }

    public ArrayList<Buyer> retreiveBuyers() {
        return mmsbr.getAllBuyers();
    }

    public ArrayList<Seller> retreiveSellers() {
        return mmsbr.getAllSellers();
    }
}
