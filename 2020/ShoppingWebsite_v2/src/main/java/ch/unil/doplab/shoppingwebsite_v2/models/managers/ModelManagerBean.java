package ch.unil.doplab.shoppingwebsite_v2.models.managers;

import ch.unil.doplab.shoppingwebsite_v2.User;
import ch.unil.doplab.shoppingwebsite_v2.UserList;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.InsufficientBalanceException;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite_v2.models.Admin;
import ch.unil.doplab.shoppingwebsite_v2.models.Buyer;
import ch.unil.doplab.shoppingwebsite_v2.models.Drink;
import ch.unil.doplab.shoppingwebsite_v2.models.Food;
import ch.unil.doplab.shoppingwebsite_v2.models.Seller;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "modelManager")
@SessionScoped
public class ModelManagerBean implements Serializable {

    private User currentUser;

    private static UserList userList = UserList.getInstance();

    private String username = "";
    private String firstName = "";
    private String lastName = "";
    private String password = "";
    private String email = "";

    private String shopName = "";

    private double amount;
    
    private String foodName = "";
    private double foodPrice = 0;
    private String hasMeat = "";
    private String ingredientsBefore = "";

    private String drinkName = "";
    private double drinkPrice = 0;
    private String hasAlcohol = "";

    public User getCurrentUser() {
        return currentUser;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static UserList getUserList() {
        return userList;
    }

    public static void setUserList(UserList userList) {
        ModelManagerBean.userList = userList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getHasMeat() {
        return hasMeat;
    }

    public void setHasMeat(String hasMeat) {
        this.hasMeat = hasMeat;
    }

    public String getIngredientsBefore() {
        return ingredientsBefore;
    }

    public void setIngredientsBefore(String ingredientsBefore) {
        this.ingredientsBefore = ingredientsBefore;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getHasAlcohol() {
        return hasAlcohol;
    }

    public void setHasAlcohol(String hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

    public Seller retrieveCurrentSeller() {
        return (Seller) currentUser;
    }

    public Buyer retrieveCurrentBuyer() {
        return (Buyer) currentUser;
    }

    public String createAnAdmin() {
        try {
            if (isAdmin(currentUser) && !emailExists(email) && !usernameExists(username)) {
                Admin admin = new Admin();
                admin.setUsername(username);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                admin.setPassword(password);
                admin.setEmail(email);
                userList.addAnAdmin(admin);
            }
        } catch (AlreadyExistsException | UnauthorizedActionException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    public String createABuyer() {
        try {
            if (!emailExists(email) && !usernameExists(username)) {
                Buyer buyer = new Buyer();
                buyer.setUsername(username);
                buyer.setFirstName(firstName);
                buyer.setLastName(lastName);
                buyer.setEmail(email);
                buyer.setPassword(password);
                userList.addABuyer(buyer);
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public String createASeller() {
        try {
            if (!emailExists(email) && !usernameExists(username)) {
                Seller seller = new Seller();
                seller.setUsername(username);
                seller.setFirstName(firstName);
                seller.setLastName(lastName);
                seller.setEmail(email);
                seller.setPassword(password);
                userList.addASeller(seller);
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public String removeAnAdmin() {
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

    public String removeABuyer() {
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

    public String removeASeller() {
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

    public String userLogsIn() {
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

    public String userLogsout() {
        currentUser = null;
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public String verifyAShop() {
        try {
            if (isAdmin(currentUser)) {
                findSellerByShopName().setVerified(true);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    public Seller findSellerByShopName() throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(shopName)) {
                return (Seller) user;
            }
        }
        throw new DoesNotExistException("The user " + shopName + " does not exist.");
    }

    public ArrayList<User> retreiveUsers() {
        return userList.getUsers();
    }

    public ArrayList<Admin> retreiveAdmins() {
        return userList.getAdmins();
    }

    public ArrayList<Buyer> retreiveBuyers() {
        return userList.getBuyers();
    }

    public ArrayList<Seller> retreiveSellers() {
        return userList.getSellers();
    }

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

    public String addADrinkToShop() {
        try {
            if (isSellerAuthorized(currentUser) && !doesDrinkExistInAShop(currentUser, drinkName, 'a')) {
                Drink drink = new Drink();
                drink.setName(drinkName);
                drink.setPrice(drinkPrice);
                drink.setHasAcohol(hasAlcohol.equals("true") ? true : false);
                ((Seller) currentUser).getDrinks().add(drink);
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    public String addAFoodToShop() {
        try {
            if (isSellerAuthorized(currentUser) && !doesFoodExistInAShop(currentUser, foodName, 'a')) {
                Food food = new Food();
                food.setName(foodName);
                food.setPrice(foodPrice);
                food.setHasMeat(hasMeat.equals("true") ? true : false);
                food.getIngredients().addAll(Arrays.asList(ingredientsBefore.split(",")));
                ((Seller) currentUser).getFoods().add(food);
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    public String removeADrinkFromShop() {
        try {
            if (isSellerAuthorized(currentUser) && doesDrinkExistInAShop(currentUser, drinkName, 'r')) {
                ((Seller) currentUser).getDrinks().remove(findADrinkByNameInAShop(currentUser, drinkName));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    public String removeAFoodFromShop() {
        try {
            if (isSellerAuthorized(currentUser) && doesFoodExistInAShop(currentUser, foodName, 'r')) {
                ((Seller) currentUser).getFoods().remove(findAFoodByNameInAShop(currentUser, foodName));
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    public String addADrinkToShoppingCart() {
        try {
            Drink d = findADrinkByNameInAShop(findSellerByShopName(), drinkName);
            if (isBuyerAuthorized(currentUser)) {
                ((Buyer) currentUser).getShoppingCart().addADrink(d);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    public String addAFoodToShoppingCart() {
        try {
            Food f = findAFoodByNameInAShop(findSellerByShopName(), foodName);
            if (isBuyerAuthorized(currentUser)) {
                ((Buyer) currentUser).getShoppingCart().addAFood(f);
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    public String removeADrinkFromShoppingCart() {
        try {
            if (isBuyerAuthorized(currentUser) && doesDrinkExistInShoppingCart(currentUser, drinkName)) {
                ((Buyer) currentUser).getShoppingCart().removeADrink(findADrinkByNameInAShoppingCart(currentUser, drinkName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    public String removeAFoodFromShoppingCart() {
        try {
            if (isBuyerAuthorized(currentUser) && doesFoodExistInShoppingCart(currentUser, foodName)) {
                ((Buyer) currentUser).getShoppingCart().removeAFood(findAFoodByNameInAShoppingCart(currentUser, foodName));
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    public String completePurchasement() {
        try {
            retrieveCurrentBuyer().completePurchasement();
        } catch (InsufficientBalanceException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
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
}
