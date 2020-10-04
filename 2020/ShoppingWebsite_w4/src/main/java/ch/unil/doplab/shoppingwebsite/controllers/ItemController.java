package ch.unil.doplab.shoppingwebsite.controllers;

import ch.unil.doplab.shoppingwebsite.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite.items.Drink;
import ch.unil.doplab.shoppingwebsite.items.Food;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class ItemController {

    public static void addADrinkToShop(User user, String drinkName, double drinkPrice, boolean containsAlcohol) {
        try {
            if (isSellerAuthorized(user) && !doesDrinkExistInAShop(user, drinkName, 'a')) {
                ((Seller) user).getDrinks().add(new Drink(drinkName, drinkPrice, containsAlcohol));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addAFoodToShop(User user, String foodName, double foodPrice, boolean hasMeat, ArrayList<String> ingredients) {
        try {
            if (isSellerAuthorized(user) && !doesFoodExistInAShop(user, foodName, 'a')) {
                ((Seller) user).getFoods().add(new Food(foodName, foodPrice, hasMeat, ingredients));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeADrinkFromShop(User user, String drinkName) {
        try {
            if (isSellerAuthorized(user) && doesDrinkExistInAShop(user, drinkName, 'r')) {
                ((Seller) user).getDrinks().remove(findADrinkByNameInAShop(user, drinkName));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeAFoodFromShop(User user, String foodName) {
        try {
            if (isSellerAuthorized(user) && doesFoodExistInAShop(user, foodName, 'r')) {
                ((Seller) user).getFoods().remove(findAFoodByNameInAShop(user, foodName));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addADrinkToShoppingCart(User user, String shopName, String drinkName) {
        try {
            Drink d = findADrinkByNameInAShop(UserController.findSellerByShopName(shopName), drinkName);
            if (isBuyerAuthorized(user)) {
                ((Buyer) user).getShoppingCart().addADrink(d);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addAFoodToShoppingCart(User user, String shopName, String foodName) {
        try {
            Food f = findAFoodByNameInAShop(UserController.findSellerByShopName(shopName), foodName);
            if (isBuyerAuthorized(user)) {
                ((Buyer) user).getShoppingCart().addAFood(f);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeADrinkFromShoppingCart(User user, String drinkName) {
        try {
            if (isBuyerAuthorized(user) && doesDrinkExistInShoppingCart(user, drinkName)) {
                ((Buyer) user).getShoppingCart().removeADrink(findADrinkByNameInAShoppingCart(user, drinkName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeAFoodFromShoppingCart(User user, String foodName) {
        try {
            if (isBuyerAuthorized(user) && doesFoodExistInShoppingCart(user, foodName)) {
                ((Buyer) user).getShoppingCart().removeAFood(findAFoodByNameInAShoppingCart(user, foodName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static boolean doesDrinkExistInAShop(User user, String drinkName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        for (Drink d : ((Seller) user).getDrinks()) {
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

    private static boolean doesFoodExistInAShop(User user, String foodName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        for (Food f : ((Seller) user).getFoods()) {
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

    private static boolean doesDrinkExistInShoppingCart(User user, String drinkName) {
        for (Drink d : ((Buyer) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesFoodExistInShoppingCart(User user, String foodName) {
        for (Food f : ((Buyer) user).getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    private static Drink findADrinkByNameInAShop(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Seller) user).getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private static Food findAFoodByNameInAShop(User user, String foodName) throws DoesNotExistException {
        for (Food f : ((Seller) user).getFoods()) {
            if (f.getName().equals(foodName)) {
                return f;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private static Drink findADrinkByNameInAShoppingCart(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Buyer) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private static Food findAFoodByNameInAShoppingCart(User user, String foodName) throws DoesNotExistException {
        for (Food f : ((Buyer) user).getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                return f;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private static boolean isSellerAuthorized(User user) throws UnauthorizedActionException {
        if (user instanceof Seller) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

    private static boolean isBuyerAuthorized(User user) throws UnauthorizedActionException {
        if (user instanceof Buyer) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }
}
