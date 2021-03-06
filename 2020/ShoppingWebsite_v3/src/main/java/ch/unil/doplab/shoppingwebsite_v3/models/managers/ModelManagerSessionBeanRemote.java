package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import ch.unil.doplab.shoppingwebsite_v3.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v3.models.Admin;
import ch.unil.doplab.shoppingwebsite_v3.models.Buyer;
import ch.unil.doplab.shoppingwebsite_v3.models.Drink;
import ch.unil.doplab.shoppingwebsite_v3.models.Food;
import ch.unil.doplab.shoppingwebsite_v3.models.Seller;
import ch.unil.doplab.shoppingwebsite_v3.models.User;
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

    String createAnAdmin(Admin admin);

    String createABuyer(Buyer buyer);

    String createASeller(Seller seller);

    String removeAnAdmin(String username);

    String removeABuyer(String username);

    String removeASeller(String username);

    ArrayList<User> getAllUsers();

    ArrayList<Admin> getAllAdmins();

    ArrayList<Buyer> getAllBuyers();

    ArrayList<Seller> getAllSellers();

    User getCurrentUser();

    String verifyAShop(String shopName);

    Seller findSellerByShopName(String shopName) throws DoesNotExistException;

    String addADrinkToShop(Drink drink);

    String addAFoodToShop(Food food);

    String removeADrinkFromShop(String drinkName);

    String removeAFoodFromShop(String foodName);

    String addADrinkToShoppingCart(String drinkName, String shopName);

    String addAFoodToShoppingCart(String foodName, String shopName);

    String removeADrinkFromShoppingCart(String drinkName);

    String removeAFoodFromShoppingCart(String foodName);

    String completePurchasement();
}
