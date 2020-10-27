/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
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

    private String shopName = "";

    private double amount;

    private String foodName = "";
    private double foodPrice = 0;
    private String hasMeat = "";
    private String ingredientsBefore = "";

    private String drinkName = "";
    private double drinkPrice = 0;
    private String hasAlcohol = "";

    public String userLogsIn() {
        return mmsbr.userLogsIn(username, password);
    }

    public String userLogsout() {
        return mmsbr.userLogsout();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getHasMeat() {
        return hasMeat;
    }

    public void setHasMeat(String hasMeat) {
        this.hasMeat = hasMeat;
    }

    public String getIngredientsBefore() {
        return ingredientsBefore;
    }

    public void setIngredientsBefore(String ingredientsBefore) {
        this.ingredientsBefore = ingredientsBefore;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getHasAlcohol() {
        return hasAlcohol;
    }

    public void setHasAlcohol(String hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

}
