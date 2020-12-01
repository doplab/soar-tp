package ch.unil.doplab.shoppingwebsite_v4.models.managers;

import ch.unil.doplab.shoppingwebsite_v4.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite_v4.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v4.exceptions.InsufficientBalanceException;
import ch.unil.doplab.shoppingwebsite_v4.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite_v4.models.Items;
import ch.unil.doplab.shoppingwebsite_v4.models.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Stateless(name = "mmsbr")
@TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class ModelManagerSessionBean implements ModelManagerSessionBeanRemote {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private Users currentUser;

    @Override
    public String userLogsIn(String username, String password) {
        try {
            currentUser = findByUsername(username);
            if (currentUser != null && currentUser.isPasswordCorrect(password)) {
                if (currentUser.getUserClass().equals("a")) {
                    return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
                } else if (currentUser.getUserClass().equals("b")) {
                    return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
                } else if (currentUser.getUserClass().equals("s")) {
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
    public String createAnAdmin(Users admin) {
        try {
            if (isAdmin(currentUser) && !emailExists(admin.getEmail()) && !usernameExists(admin.getUsername())) {
                // TODO: Complete this method
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String createABuyer(Users buyer) {
        try {
            if (!emailExists(buyer.getEmail()) && !usernameExists(buyer.getUsername())) {
                em.persist(buyer);
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String createASeller(Users seller) {
        try {
            if (!emailExists(seller.getEmail()) && !usernameExists(seller.getUsername())) {
                em.persist(seller);
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeAnAdmin(String username) {
        try {
            Users u = findByUsername(username);
            if (u != null) {
                // TODO: Complete this method
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeABuyer(String username) {
        try {
            Users user = findByUsername(username);
            if (user != null) {
                em.remove(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeASeller(String username) {
        try {
            Users user = findByUsername(username);
            if (user != null) {
                em.remove(user);
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public ArrayList<Users> getAllUsers() {
        List<Users> users = em.createNamedQuery("Users.findAll", Users.class).getResultList();
        ArrayList<Users> result = new ArrayList<>(users.size());
        result.addAll(users);
        return result;
    }

    @Override
    public ArrayList<Users> getAllAdmins() {
        List<Users> users = em.createNamedQuery("Users.findByUserClass", Users.class).setParameter("userClass", "a").getResultList();
        ArrayList<Users> result = new ArrayList<>(users.size());
        result.addAll(users);
        return result;
    }

    @Override
    public ArrayList<Users> getAllBuyers() {
        List<Users> users = em.createNamedQuery("Users.findByUserClass", Users.class).setParameter("userClass", "b").getResultList();
        ArrayList<Users> result = new ArrayList<>(users.size());
        result.addAll(users);
        return result;
    }

    @Override
    public ArrayList<Users> getAllSellers() {
        List<Users> users = em.createNamedQuery("Users.findByUserClass", Users.class).setParameter("userClass", "s").getResultList();
        ArrayList<Users> result = new ArrayList<>(users.size());
        result.addAll(users);
        return result;
    }

    @Override
    public Users getCurrentUser() {
        return currentUser;
    }

    @Override
    public String verifyAShop(String shopName) {
        try {
            if (isAdmin(currentUser)) {
                Users u = findSellerByShopName(shopName);
                em.createNativeQuery("UPDATE users u SET u.verified = ? WHERE u.user_id = ?")
                        .setParameter(1, "t")
                        .setParameter(2, u.getUserId())
                        .executeUpdate();
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public Users findSellerByShopName(String shopName) throws DoesNotExistException {
        List<Users> users = em.createNamedQuery("Users.findByUsername", Users.class).setParameter("username", shopName).getResultList();
        if (users.size() == 0) {
            throw new DoesNotExistException("The user " + shopName + " does not exist.");
        } else {
            return users.get(0);
        }
    }

    @Override
    public String addADrinkToShop(Items drink) {
        try {
            if (isSellerAuthorized(currentUser) && !doesDrinkExistInAShop(currentUser, drink.getItemName(), 'a')) {
                // TODO: Complete this method
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addAFoodToShop(Items food) {
        try {
            if (isSellerAuthorized(currentUser) && !doesFoodExistInAShop(currentUser, food.getItemName(), 'a')) {
                em.persist(food);
                Items persistedFood = findAnItemByName(food.getItemName());
                em.createNativeQuery("INSERT INTO user_has_item (USER_ID, ITEM_ID) VALUES (?, ?)")
                        .setParameter(1, currentUser.getUserId())
                        .setParameter(2, persistedFood.getItemId())
                        .executeUpdate();
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
                Items i = findAnItemByName(drinkName);
                if (i != null) {
                    // TODO: Complete this method
                }
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
                Items i = findAnItemByName(foodName);
                if (i != null) {
                    em.remove(i);
                }
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addADrinkToShoppingCart(String drinkName, String shopName) {
        try {
            Items drink = findADrinkByNameInAShop(findSellerByShopName(shopName), drinkName);
            if (isBuyerAuthorized(currentUser)) {
                // TODO: Complete this method
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addAFoodToShoppingCart(String foodName, String shopName) {
        try {
            Items food = findAFoodByNameInAShop(findSellerByShopName(shopName), foodName);
            if (isBuyerAuthorized(currentUser)) {
                em.createNativeQuery("INSERT INTO user_has_item (USER_ID, ITEM_ID) VALUES (?, ?)")
                        .setParameter(1, currentUser.getUserId())
                        .setParameter(2, food.getItemId())
                        .executeUpdate();
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
                Items i = findAnItemByName(drinkName);
                if (i != null) {
                    // TODO: Complete this method
                }
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
                Items i = findAnItemByName(foodName);
                if (i != null) {
                    em.createNativeQuery("DELETE FROM user_has_item u WHERE u.item_id = ?")
                            .setParameter(1, i.getItemId())
                            .executeUpdate();
                }
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String completePurchasement() {
        try {
            double total = 0;
            if (isBuyerAuthorized(currentUser)) {
                List<Integer> itemIDs = em.createNativeQuery("SELECT item_id FROM user_has_item WHERE user_id = ?")
                        .setParameter(1, currentUser.getUserId())
                        .getResultList();
                for (Integer itemID : itemIDs) {
                    Items item = em.createNamedQuery("Items.findByItemId", Items.class).setParameter("itemId", itemID).getResultList().get(0);
                    total += item.getItemPrice();
                }
                double balance = em.createNamedQuery("Users.findByUserId", Users.class).setParameter("userId", currentUser.getUserId()).getResultList().get(0).getBalance();
                if (total > balance) {
                    throw new InsufficientBalanceException("Deposit money before you proceed.");
                } else {
                    double newBalance = balance - total;
                    em.createNativeQuery("UPDATE users u SET u.balance = ? WHERE u.user_id = ?")
                            .setParameter(1, newBalance)
                            .setParameter(2, currentUser.getUserId())
                            .executeUpdate();
                    em.createNativeQuery("DELETE FROM user_has_item u WHERE u.user_id = ?")
                            .setParameter(1, currentUser.getUserId())
                            .executeUpdate();
                }
            }
        } catch (UnauthorizedActionException | InsufficientBalanceException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public ArrayList<Items> findItemsInAShop(String shopName) {
        List<Items> items = null;
        try {
            items = findByUsername(shopName).getItemsList();
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<Items> result = new ArrayList<>(items.size());
        result.addAll(items);
        return result;
    }

    @Override
    public ArrayList<Items> findItemsInAShoppingCart() {
        List<Items> items = null;
        try {
            items = findByUsername(currentUser.getUsername()).getItemsList();
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<Items> result = new ArrayList<>(items.size());
        result.addAll(items);
        return result;
    }

    @Override
    public String depositMoney(double amount) {
        em.createNativeQuery("UPDATE users u SET u.balance = ? WHERE u.user_id = ?")
                .setParameter(1, currentUser.getBalance() + amount)
                .setParameter(2, currentUser.getUserId())
                .executeUpdate();
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

//<editor-fold defaultstate="collapsed" desc="private  methods">
    private Users findByUsername(String username) throws DoesNotExistException {
        List<Users> users = em.createNamedQuery("Users.findByUsername", Users.class).setParameter("username", username).getResultList();
        if (users.size() == 0) {
            throw new DoesNotExistException("The user " + username + " does not exist.");
        } else {
            return users.get(0);
        }
    }

    private boolean emailExists(String email) throws AlreadyExistsException {
        List<Users> userList = em.createNamedQuery("Users.findByEmail", Users.class).setParameter("email", email).getResultList();
        if (userList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean usernameExists(String username) throws DoesNotExistException {
        List<Users> userList = em.createNamedQuery("Users.findByUsername", Users.class).setParameter("username", username).getResultList();
        if (userList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isAdmin(Users user) throws UnauthorizedActionException {
        if (user.getUserClass().equals("a")) {
            return true;
        }
        return false;
    }

    private boolean doesDrinkExistInAShop(Users user, String drinkName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        for (Items i : findByUsername(user.getUsername()).getItemsList()) {
            if (i.getItemName().equals(drinkName)) {
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

    private boolean doesFoodExistInAShop(Users user, String foodName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        for (Items i : findByUsername(user.getUsername()).getItemsList()) {
            if (i.getItemName().equals(foodName)) {
                if (methodCode == 'a') {
                    throw new AlreadyExistsException("The food " + foodName + " already exists.");
                }
                return true;
            }
        }
        if (methodCode == 'r') {
            throw new DoesNotExistException("The food " + foodName + " does not exist.");
        }
        return false;
    }

    private boolean doesDrinkExistInShoppingCart(Users user, String drinkName) throws DoesNotExistException {
        return findADrinkByNameInAShoppingCart(user, drinkName) != null;
    }

    private boolean doesFoodExistInShoppingCart(Users user, String foodName) throws DoesNotExistException {
        return findAFoodByNameInAShoppingCart(user, foodName) != null;
    }

    private Items findADrinkByNameInAShop(Users user, String drinkName) throws DoesNotExistException {
        for (Items item : findItemsInAShop(user.getUsername())) {
            if (item.getItemName().equals(drinkName)) {
                return item;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private Items findAFoodByNameInAShop(Users user, String foodName) throws DoesNotExistException {
        for (Items item : findItemsInAShop(user.getUsername())) {
            if (item.getItemName().equals(foodName)) {
                return item;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private Items findADrinkByNameInAShoppingCart(Users user, String drinkName) throws DoesNotExistException {
        for (Items item : findItemsInAShoppingCart()) {
            if (item.getItemName().equals(drinkName)) {
                return item;
            }
        }
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private Items findAFoodByNameInAShoppingCart(Users user, String foodName) throws DoesNotExistException {
        for (Items item : findItemsInAShoppingCart()) {
            if (item.getItemName().equals(foodName)) {
                return item;
            }
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private Items findAnItemByName(String itemName) throws DoesNotExistException {
        List<Items> items = em.createNamedQuery("Items.findByItemName", Items.class)
                .setParameter("itemName", itemName)
                .getResultList();
        if (items.size() != 0) {
            return items.get(0);
        } else {
            throw new DoesNotExistException("The item does not exist.");
        }
    }

    private boolean isSellerAuthorized(Users user) throws UnauthorizedActionException {
        if (user.getUserClass().equals("s")) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

    private boolean isBuyerAuthorized(Users user) throws UnauthorizedActionException {
        if (user.getUserClass().equals("b")) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

//</editor-fold>
}
