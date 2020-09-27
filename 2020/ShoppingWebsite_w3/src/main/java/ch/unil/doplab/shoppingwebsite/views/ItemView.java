package ch.unil.doplab.shoppingwebsite.views;

import ch.unil.doplab.shoppingwebsite.controllers.UserController;
import ch.unil.doplab.shoppingwebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite.users.Buyer;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class ItemView {

    public static void printItemsInAShop(String shopName) {
        try {
            System.out.println(UserController.findSellerByShopName(shopName).productsToString());
        } catch (DoesNotExistException ex) {
            System.out.println("Shop name does not exist.");
        }
    }

    public static void printAllItemsInAShoppingCart(Buyer buyer) {
        System.out.println(buyer.getShoppingCart().toString());
    }

}
