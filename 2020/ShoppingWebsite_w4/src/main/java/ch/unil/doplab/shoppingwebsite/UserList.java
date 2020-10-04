package ch.unil.doplab.shoppingwebsite;

import ch.unil.doplab.shoppingwebsite.users.Admin;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;
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
    }

    // we need an admin to add another admin
    // thus, we add the first admin manually
    public void addTheFirstAdmin(Admin admin) {
        users.add(admin);
        admins.add(admin);
    }

    public static UserList getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new UserList();
        }
        return singletonInstance;
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
