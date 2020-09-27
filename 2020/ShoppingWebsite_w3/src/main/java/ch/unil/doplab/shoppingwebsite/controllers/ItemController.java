package ch.unil.doplab.shoppingwebsite.controllers;

import ch.unil.doplab.shoppingwebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite.items.Drink;
// TODO/Food : uncomment
//import ch.unil.doplab.shoppingwebsite.items.Food;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class ItemController {

    public static void addADrinkToShop(User user, String drinkName, double drinkPrice, boolean containsAlcohol) {
        try {
            if (isSellerAuthorized(user) && !doesDrinkExistInAShop(user, drinkName)) {
                ((Seller) user).getDrinks().add(new Drink(drinkName, drinkPrice, containsAlcohol));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

// TODO/Food : complete this method
//    public static void addAFoodToShop(User user, String foodName, double foodPrice, boolean hasMeat, ArrayList<String> ingredients) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    public static void removeADrinkFromShop(User user, String drinkName) {
        try {
            if (isSellerAuthorized(user) && doesDrinkExistInAShop(user, drinkName)) {
                ((Seller) user).getDrinks().remove(findADrinkByNameInAShop(user, drinkName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

// TODO/Food : complete this method
//    public static void removeAFoodFromShop(User user, String foodName) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

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

// TODO/Food : complete this method
//    public static void addAFoodToShoppingCart(User user, String shopName, String foodName) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    public static void removeADrinkFromShoppingCart(User user, String drinkName) {
        try {
            if (isBuyerAuthorized(user) && doesDrinkExistInShoppingCart(user, drinkName)) {
                ((Buyer) user).getShoppingCart().removeADrink(findADrinkByNameInAShoppingCart(user, drinkName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

// TODO/Food : complete this method
//    public static void removeAFoodFromShoppingCart(User user, String foodName) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    private static boolean doesDrinkExistInAShop(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Seller) user).getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return true;
            }
        }
        return false;
    }

// TODO/Food : complete this method 
//    private static boolean doesFoodExistInAShop(User user, String foodName) throws DoesNotExistException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    private static boolean doesDrinkExistInShoppingCart(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Buyer) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return true;
            }
        }
        return false;
    }

// TODO/Food : complete this method
//    private static boolean doesFoodExistInShoppingCart(User user, String foodName) throws DoesNotExistException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    private static Drink findADrinkByNameInAShop(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Seller) user).getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

// TODO/Food : complete this method
//    private static Food findAFoodByNameInAShop(User user, String foodName) throws DoesNotExistException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
    private static Drink findADrinkByNameInAShoppingCart(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Buyer) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }
    
// TODO/Food : complete this method
//    private static Food findAFoodByNameInAShoppingCart(User user, String foodName) throws DoesNotExistException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

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
