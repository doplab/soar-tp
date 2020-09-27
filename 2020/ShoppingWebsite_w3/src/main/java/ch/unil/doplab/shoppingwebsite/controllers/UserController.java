package ch.unil.doplab.shoppingwebsite.controllers;

import ch.unil.doplab.shoppingwebsite.UserList;
import ch.unil.doplab.shoppingwebsite.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite.users.Admin;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class UserController {

    private static UserList userList = UserList.getInstance();

    public static void createAnAdmin(User user, String username, String firstName, String lastName, String email, String password) {
        try {
            if (isAdmin(user) && !emailExists(email) && !usernameExists(username)) {
                userList.addAnAdmin(new Admin(username, firstName, lastName, email, password));
            }
        } catch (AlreadyExistsException | UnauthorizedActionException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createABuyer(String username, String firstName, String lastName, String email, String password) {
        try {
            if (!emailExists(email) && !usernameExists(username)) {
                userList.addABuyer(new Buyer(username, firstName, lastName, email, password));
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createASeller(String shopName, String firstName, String lastName, String email, String password) {
        try {
            if (!emailExists(email) && !usernameExists(shopName)) {
                userList.addASeller(new Seller(shopName, firstName, lastName, email, password));
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeAnAdmin(String userName) {
        try {
            User u = findByUsername(userName);
            if (u != null) {
                userList.removeAnAdmin(u);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeABuyer(String userName) {
        try {
            User user = findByUsername(userName);
            if (user != null) {
                userList.removeABuyer(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void removeASeller(String userName) {
        try {
            User user = findByUsername(userName);
            if (user != null) {
                userList.removeASeller(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static User userLogsIn(String username, String password) {
        try {
            User user = findByUsername(username);
            if (user != null && user.isPasswordCorrect(password)) {
                return user;
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void verifyAShop(User user, String shopName) {
        try {
            if (isAdmin(user)) {
                findSellerByShopName(shopName).setVerified(true);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Seller findSellerByShopName(String shopName) throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(shopName)) {
                return (Seller) user;
            }
        }
        throw new DoesNotExistException("The user " + shopName + " does not exist.");
    }

    private static User findByUsername(String username) throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    private static boolean emailExists(String email) throws AlreadyExistsException {
        for (User user : userList.getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already in use.");
            }
        }
        return false;
    }

    private static boolean usernameExists(String username) throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAdmin(User user) throws UnauthorizedActionException {
        if (user instanceof Admin) {
            return true;
        }
        return false;
    }

}
