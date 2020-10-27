package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import ch.unil.doplab.shoppingwebsite_3.UserList;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.InsufficientBalanceException;
import ch.unil.doplab.shoppingwebsite_v3.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite_v3.models.Admin;
import ch.unil.doplab.shoppingwebsite_v3.models.Buyer;
import ch.unil.doplab.shoppingwebsite_v3.models.Drink;
import ch.unil.doplab.shoppingwebsite_v3.models.Food;
import ch.unil.doplab.shoppingwebsite_v3.models.Seller;
import ch.unil.doplab.shoppingwebsite_v3.models.User;
import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Stateful(name = "mmsbr")
public class ModelManagerSessionBean implements ModelManagerSessionBeanRemote {

    private User currentUser;

    private static UserList userList = UserList.getInstance();

    @Override
    public String userLogsIn(String username, String password) {
        try {
            currentUser = findByUsername(username);
            if (currentUser != null && currentUser.isPasswordCorrect(password)) {
                if (currentUser instanceof Admin) {
                    return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
                } else if (currentUser instanceof Buyer) {
                    return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
                } else if (currentUser instanceof Seller) {
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

    @Override
    public String createAnAdmin(Admin admin) {
        try {
            if (isAdmin(currentUser) && !emailExists(admin.getEmail()) && !usernameExists(admin.getUsername())) {
                userList.addAnAdmin(admin);
            }
        } catch (AlreadyExistsException | UnauthorizedActionException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String createABuyer(Buyer buyer) {
        try {
            if (!emailExists(buyer.getEmail()) && !usernameExists(buyer.getUsername())) {
                userList.addABuyer(buyer);
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String createASeller(Seller seller) {
        try {
            if (!emailExists(seller.getEmail()) && !usernameExists(seller.getUsername())) {
                userList.addASeller(seller);
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeAnAdmin(String username) {
        try {
            User u = findByUsername(username);
            if (u != null) {
                userList.removeAnAdmin(u);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeABuyer(String username) {
        try {
            User user = findByUsername(username);
            if (user != null) {
                userList.removeABuyer(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeASeller(String username) {
        try {
            User user = findByUsername(username);
            if (user != null) {
                userList.removeASeller(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return userList.getUsers();
    }

    @Override
    public ArrayList<Admin> getAllAdmins() {
        return userList.getAdmins();
    }

    @Override
    public ArrayList<Buyer> getAllBuyers() {
        return userList.getBuyers();
    }

    @Override
    public ArrayList<Seller> getAllSellers() {
        return userList.getSellers();
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public String verifyAShop(String shopName) {
        try {
            if (isAdmin(currentUser)) {
                findSellerByShopName(shopName).setVerified(true);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public Seller findSellerByShopName(String shopName) throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(shopName)) {
                return (Seller) user;
            }
        }
        throw new DoesNotExistException("The user " + shopName + " does not exist.");
    }

    @Override
    public String addADrinkToShop(Drink drink) {
        try {
            if (isSellerAuthorized(currentUser) && !doesDrinkExistInAShop(currentUser, drink.getName(), 'a')) {
                ((Seller) currentUser).getDrinks().add(drink);
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addAFoodToShop(Food food) {
        try {
            if (isSellerAuthorized(currentUser) && !doesFoodExistInAShop(currentUser, food.getName(), 'a')) {
                ((Seller) currentUser).getFoods().add(food);
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeADrinkFromShop(String drinkName) {
        try {
            if (isSellerAuthorized(currentUser) && doesDrinkExistInAShop(currentUser, drinkName, 'r')) {
                ((Seller) currentUser).getDrinks().remove(findADrinkByNameInAShop(currentUser, drinkName));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeAFoodFromShop(String foodName) {
        try {
            if (isSellerAuthorized(currentUser) && doesFoodExistInAShop(currentUser, foodName, 'r')) {
                ((Seller) currentUser).getFoods().remove(findAFoodByNameInAShop(currentUser, foodName));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addADrinkToShoppingCart(String drinkName, String shopName) {
        try {
            Drink d = findADrinkByNameInAShop(findSellerByShopName(shopName), drinkName);
            if (isBuyerAuthorized(currentUser)) {
                ((Buyer) currentUser).getShoppingCart().addADrink(d);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addAFoodToShoppingCart(String foodName, String shopName) {
        try {
            Food food = findAFoodByNameInAShop(findSellerByShopName(shopName), foodName);
            if (isBuyerAuthorized(currentUser)) {
                ((Buyer) currentUser).getShoppingCart().addAFood(food);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeADrinkFromShoppingCart(String drinkName) {
        try {
            if (isBuyerAuthorized(currentUser) && doesDrinkExistInShoppingCart(currentUser, drinkName)) {
                ((Buyer) currentUser).getShoppingCart().removeADrink(findADrinkByNameInAShoppingCart(currentUser, drinkName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeAFoodFromShoppingCart(String foodName) {
        try {
            if (isBuyerAuthorized(currentUser) && doesFoodExistInShoppingCart(currentUser, foodName)) {
                ((Buyer) currentUser).getShoppingCart().removeAFood(findAFoodByNameInAShoppingCart(currentUser, foodName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String completePurchasement() {
        try {
            ((Buyer) currentUser).completePurchasement();
        } catch (InsufficientBalanceException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

//<editor-fold defaultstate="collapsed" desc="private  methods">
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
        if (user instanceof Admin) {
            return true;
        }
        return false;
    }

    private boolean doesDrinkExistInAShop(User user, String drinkName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
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

    private boolean doesFoodExistInAShop(User user, String foodName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
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

    private boolean doesDrinkExistInShoppingCart(User user, String drinkName) {
        for (Drink d : ((Buyer) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesFoodExistInShoppingCart(User user, String foodName) {
        for (Food f : ((Buyer) user).getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    private Drink findADrinkByNameInAShop(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Seller) user).getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private Food findAFoodByNameInAShop(User user, String foodName) throws DoesNotExistException {
        for (Food f : ((Seller) user).getFoods()) {
            if (f.getName().equals(foodName)) {
                return f;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private Drink findADrinkByNameInAShoppingCart(User user, String drinkName) throws DoesNotExistException {
        for (Drink d : ((Buyer) user).getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                return d;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private Food findAFoodByNameInAShoppingCart(User user, String foodName) throws DoesNotExistException {
        for (Food f : ((Buyer) user).getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                return f;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private boolean isSellerAuthorized(User user) throws UnauthorizedActionException {
        if (user instanceof Seller) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

    private boolean isBuyerAuthorized(User user) throws UnauthorizedActionException {
        if (user instanceof Buyer) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

//</editor-fold>
}
