package ch.unil.doplab.shoppingwebsite_v2.models.managers;

import ch.unil.doplab.shoppingwebsite_v2.User;
import ch.unil.doplab.shoppingwebsite_v2.UserList;
import ch.unil.doplab.shoppingwebsite_v2.models.AdminBean;
import ch.unil.doplab.shoppingwebsite_v2.models.BuyerBean;
import ch.unil.doplab.shoppingwebsite_v2.models.SellerBean;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite_v2.exceptions.UnauthorizedActionException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "userControllerBean")
@SessionScoped
public class UserControllerBean implements Serializable {

    private User currentUser;

    private AdminBean adminBean = new AdminBean();
    private BuyerBean buyerBean = new BuyerBean();
    private SellerBean sellerBean = new SellerBean();

    private static UserList userList = UserList.getInstance();

    private String username = "";
    private String password = "";
    private String shopName = "";

    public UserControllerBean() {
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public AdminBean getAdminBean() {
        return adminBean;
    }

    public BuyerBean getBuyerBean() {
        return buyerBean;
    }

    public SellerBean getSellerBean() {
        return sellerBean;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getShopName() {
        return shopName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String createAnAdmin() {
        try {
            if (isAdmin(currentUser) && !emailExists(adminBean.getEmail()) && !usernameExists(adminBean.getUsername())) {
                userList.addAnAdmin(adminBean);
                adminBean = new AdminBean();
            }
        } catch (AlreadyExistsException | UnauthorizedActionException | DoesNotExistException ex) {
            adminBean = new AdminBean();
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    public String createABuyer() {
        try {
            if (!emailExists(buyerBean.getEmail()) && !usernameExists(buyerBean.getUsername())) {
                userList.addABuyer(buyerBean);
                buyerBean = new BuyerBean();
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            buyerBean = new BuyerBean();
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public String createASeller() {
        try {
            if (!emailExists(sellerBean.getEmail()) && !usernameExists(sellerBean.getUsername())) {
                userList.addASeller(sellerBean);
                sellerBean = new SellerBean();
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            sellerBean = new SellerBean();
            System.out.println(ex.getMessage());
        }
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public String removeAnAdmin() {
        try {
            User u = findByUsername(username);
            if (u != null) {
                userList.removeAnAdmin(u);
                username = "";
            }
        } catch (DoesNotExistException ex) {
            username = "";
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    public String removeABuyer() {
        try {
            User user = findByUsername(username);
            if (user != null) {
                userList.removeABuyer(user);
                username = "";
            }
        } catch (DoesNotExistException ex) {
            username = "";
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    public String removeASeller() {
        try {
            User user = findByUsername(username);
            if (user != null) {
                userList.removeASeller(user);
                username = "";
            }
        } catch (DoesNotExistException ex) {
            username = "";
            System.out.println(ex.getMessage());
        }
        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
    }

    public String userLogsIn() {
        try {
            currentUser = findByUsername(username);
            if (currentUser != null && currentUser.isPasswordCorrect(password)) {
                username = "";
                password = "";
                if (currentUser instanceof AdminBean) {
                    return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
                } else if (currentUser instanceof BuyerBean) {
                    return "/BuyerPage/BuyerMainMenu.xhtml?faces-redirect=true";
                } else if (currentUser instanceof SellerBean) {
                    return "/SellerPage/SellerMainMenu.xhtml?faces-redirect=true";
                }
            }
        } catch (DoesNotExistException ex) {
            username = "";
            password = "";
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

    public SellerBean findSellerByShopName() throws DoesNotExistException {
        for (User user : userList.getUsers()) {
            if (user.getUsername().equals(shopName)) {
                shopName = "";
                return (SellerBean) user;
            }
        }
        throw new DoesNotExistException("The user " + shopName + " does not exist.");
    }

    public ArrayList<User> retreiveUsers() {
        return userList.getUsers();
    }

    public ArrayList<AdminBean> retreiveAdmins() {
        return userList.getAdmins();
    }

    public ArrayList<BuyerBean> retreiveBuyers() {
        return userList.getBuyers();
    }

    public ArrayList<SellerBean> retreiveSellers() {
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
        if (user instanceof AdminBean) {
            return true;
        }
        return false;
    }
}
