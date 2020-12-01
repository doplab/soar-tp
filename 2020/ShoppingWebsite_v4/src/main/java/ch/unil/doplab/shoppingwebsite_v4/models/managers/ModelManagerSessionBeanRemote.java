package ch.unil.doplab.shoppingwebsite_v4.models.managers;

import ch.unil.doplab.shoppingwebsite_v4.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v4.models.Items;
import ch.unil.doplab.shoppingwebsite_v4.models.Users;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Remote
public interface ModelManagerSessionBeanRemote {

    String userLogsIn(String username, String password);

    String userLogsout();

    String createAnAdmin(Users admin);

    String createABuyer(Users buyer);

    String createASeller(Users seller);

    String removeAnAdmin(String username);

    String removeABuyer(String username);

    String removeASeller(String username);

    ArrayList<Users> getAllUsers();

    ArrayList<Users> getAllAdmins();

    ArrayList<Users> getAllBuyers();

    ArrayList<Users> getAllSellers();

    Users getCurrentUser();

    String verifyAShop(String shopName);

    Users findSellerByShopName(String shopName) throws DoesNotExistException;

    String addADrinkToShop(Items drink);

    String addAFoodToShop(Items food);

    String removeADrinkFromShop(String drinkName);

    String removeAFoodFromShop(String foodName);

    String addADrinkToShoppingCart(String drinkName, String shopName);

    String addAFoodToShoppingCart(String foodName, String shopName);

    String removeADrinkFromShoppingCart(String drinkName);

    String removeAFoodFromShoppingCart(String foodName);

    String completePurchasement();

    ArrayList<Items> findItemsInAShop(String shopName);

    ArrayList<Items> findItemsInAShoppingCart();

    String depositMoney(double amount);
}
