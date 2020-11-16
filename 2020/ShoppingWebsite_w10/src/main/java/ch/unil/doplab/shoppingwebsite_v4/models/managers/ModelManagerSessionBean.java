package ch.unil.doplab.shoppingwebsite_v4.models.managers;

import ch.unil.doplab.shoppingwebsite_v4.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite_v4.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v4.exceptions.UnauthorizedActionException;
import ch.unil.doplab.shoppingwebsite_v4.models.Admin;
import ch.unil.doplab.shoppingwebsite_v4.models.Buyer;
import ch.unil.doplab.shoppingwebsite_v4.models.Drink;
import ch.unil.doplab.shoppingwebsite_v4.models.Food;
import ch.unil.doplab.shoppingwebsite_v4.models.Seller;
import ch.unil.doplab.shoppingwebsite_v4.models.Users;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
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
    
    @Resource
    SessionContext context;
    
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
    public String createAnAdmin(Admin admin) {
        try {
            if (isAdmin(currentUser) && !emailExists(admin.getEmail()) && !usernameExists(admin.getUsername())) {
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    // TODO: complete
    @Override
    public ArrayList<Users> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // TODO: complete
    @Override
    public ArrayList<Admin> getAllAdmins() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // TODO: complete
    @Override
    public ArrayList<Buyer> getAllBuyers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // TODO: complete
    @Override
    public ArrayList<Seller> getAllSellers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Users getCurrentUser() {
        return currentUser;
    }

    @Override
    public String verifyAShop(String shopName) {
//        try {
//            if (isAdmin(currentUser)) {
//                // TODO: complete
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public Seller findSellerByShopName(String shopName) throws DoesNotExistException {
        // TODO: complete
        throw new DoesNotExistException("The user " + shopName + " does not exist.");
    }

    @Override
    public String addADrinkToShop(Drink drink) {
        try {
            if (isSellerAuthorized(currentUser) && !doesDrinkExistInAShop(currentUser, drink.getItemName(), 'a')) {
                // TODO: complete
            }
        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String addAFoodToShop(Food food) {
        try {
            if (isSellerAuthorized(currentUser) && !doesFoodExistInAShop(currentUser, food.getItemName(), 'a')) {
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
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
                // TODO: complete
            }
        } catch (DoesNotExistException | UnauthorizedActionException ex) {
            System.out.println(ex.getMessage());
        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeADrinkFromShoppingCart(String drinkName) {
//        try {
//            if (isBuyerAuthorized(currentUser) && doesDrinkExistInShoppingCart(currentUser, drinkName)) {
//                // TODO: complete
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String removeAFoodFromShoppingCart(String foodName) {
//        try {
//            if (isBuyerAuthorized(currentUser) && doesFoodExistInShoppingCart(currentUser, foodName)) {
//                // TODO: complete
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

    @Override
    public String completePurchasement() {
//        try {
//            // TODO: complete
//        } catch (InsufficientBalanceException ex) {
//            System.out.println(ex.getMessage());
//        }
        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
    }

//<editor-fold defaultstate="collapsed" desc="private  methods">
    private Users findByUsername(String username) throws DoesNotExistException {
        Users u = (Users) em.createNamedQuery("Users.findByUsername", Users.class).setParameter("username", username).getSingleResult();
        if (u == null) {
            throw new DoesNotExistException("The user " + username + " does not exist.");
        } else {
            return u;
        }
    }

    private boolean emailExists(String email) throws AlreadyExistsException {
        // TODO: complete
        return false;
    }

    private boolean usernameExists(String username) throws DoesNotExistException {
        // TODO: complete
        return false;
    }

    private boolean isAdmin(Users user) throws UnauthorizedActionException {
        if (user instanceof Admin) {
            return true;
        }
        return false;
    }

    private boolean doesDrinkExistInAShop(Users user, String drinkName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        // TODO: complete
        if (methodCode == 'r') {
            throw new DoesNotExistException("The drink " + drinkName + " does not exist.");
        }
        return false;
    }

    private boolean doesFoodExistInAShop(Users user, String foodName, char methodCode) throws AlreadyExistsException, DoesNotExistException {
        // TODO: complete
        if (methodCode == 'r') {
            throw new DoesNotExistException("The food " + foodName + " already exist.");
        }
        return false;
    }

    private boolean doesDrinkExistInShoppingCart(Users user, String drinkName) {
        // TODO: complete
        return false;
    }

    private boolean doesFoodExistInShoppingCart(Users user, String foodName) {
        // TODO: complete
        return false;
    }

    private Drink findADrinkByNameInAShop(Users user, String drinkName) throws DoesNotExistException {
        // TODO: complete
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private Food findAFoodByNameInAShop(Users user, String foodName) throws DoesNotExistException {
        // TODO: complete
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private Drink findADrinkByNameInAShoppingCart(Users user, String drinkName) throws DoesNotExistException {
        // TODO: complete
        throw new DoesNotExistException("Drink " + drinkName + " does not exist.");
    }

    private Food findAFoodByNameInAShoppingCart(Users user, String foodName) throws DoesNotExistException {
        // TODO: complete
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

    private boolean isSellerAuthorized(Users user) throws UnauthorizedActionException {
        if (user instanceof Seller) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

    private boolean isBuyerAuthorized(Users user) throws UnauthorizedActionException {
        if (user instanceof Buyer) {
            return true;
        }
        throw new UnauthorizedActionException("You are not authorized to perform the operation.");
    }

//</editor-fold>

}
