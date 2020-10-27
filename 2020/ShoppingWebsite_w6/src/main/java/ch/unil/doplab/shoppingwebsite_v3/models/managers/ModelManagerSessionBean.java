/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import ch.unil.doplab.shoppingwebsite_3.UserList;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite_v3.models.AdminBean;
import ch.unil.doplab.shoppingwebsite_v3.models.BuyerBean;
import ch.unil.doplab.shoppingwebsite_v3.models.DrinkBean;
import ch.unil.doplab.shoppingwebsite_v3.models.FoodBean;
import ch.unil.doplab.shoppingwebsite_v3.models.SellerBean;
import ch.unil.doplab.shoppingwebsite_v3.models.User;
import javax.ejb.Stateful;

/**
 *
 * @author Melike Geçer
 */
@Stateful
public class ModelManagerSessionBean implements ModelManagerSessionBeanRemote {

    private static UserList userList = UserList.getInstance();

    private User currentUser;

    @Override
    public String userLogsIn(String username, String password) {
        try {
            currentUser = findByUsername(username);
            if (currentUser != null && currentUser.isPasswordCorrect(password)) {
                if (currentUser instanceof AdminBean) {
                    return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
                } else if (currentUser instanceof BuyerBean) {
                    return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
                } else if (currentUser instanceof SellerBean) {
                    return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
                }
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/LoginPage.xhtml?faces-redirect=true";
    }

    @Override
    public String userLogsout() {
        currentUser = null;
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    // private methods
    private User findByUsername(String username) throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    private boolean emailExists(String email) throws AlreadyExistsException {
        for (User user : userList.getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already in use.");
            }
        }
        return false;
    }

    private boolean usernameExists(String username) throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdmin(User user) throws UnauthorizedActionException {
        if (user instanceof AdminBean) {
            return true;
        }
        return false;
    }

    private boolean doesDrinkExistInAShop(User user, String drinkName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        for (DrinkBean d : ((SellerBean) user).getDrinks()) {
            if (d.getName().equals(drinkName)) {
                if (methodCode == 'a') {
                    throw new AlreadyExistsException("The drink " + drinkName + " already exists.");
                }
                return true;
            }
        }
        if (methodCode == 'r') {
            throw new DoesNotExistException("The drink " + drinkName + " does not exist.");
        }
        return false;
    }

    private boolean doesFoodExistInAShop(User user, String foodName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        for (FoodBean f : ((SellerBean) user).getFoods()) {
            if (f.getName().equals(foodName)) {
                if (methodCode == 'a') {
                    throw new AlreadyExistsException("The food " + foodName + " already exists.");
                }
                return true;
            }
        }
        if (methodCode == 'r') {
            throw new DoesNotExistException("The food " + foodName + " already exist.");
        }
        return false;
    }

    private boolean doesDrinkExistInShoppingCart(User user, String drinkName) {
        for (DrinkBean d : ((BuyerBean) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesFoodExistInShoppingCart(User user, String foodName) {
        for (FoodBean f : ((BuyerBean) user).getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    private DrinkBean findADrinkByNameInAShop(User user, String drinkName) throws DoesNotExistException {
        for (DrinkBean d : ((SellerBean) user).getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private FoodBean findAFoodByNameInAShop(User user, String foodName) throws DoesNotExistException {
        for (FoodBean f : ((SellerBean) user).getFoods()) {
            if (f.getName().equals(foodName)) {
                return f;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private DrinkBean findADrinkByNameInAShoppingCart(User user, String drinkName) throws DoesNotExistException {
        for (DrinkBean d : ((BuyerBean) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private FoodBean findAFoodByNameInAShoppingCart(User user, String foodName) throws DoesNotExistException {
        for (FoodBean f : ((BuyerBean) user).getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                return f;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private boolean isSellerAuthorized(User user) throws UnauthorizedActionException {
        if (user instanceof SellerBean) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

    private boolean isBuyerAuthorized(User user) throws UnauthorizedActionException {
        if (user instanceof BuyerBean) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

}
