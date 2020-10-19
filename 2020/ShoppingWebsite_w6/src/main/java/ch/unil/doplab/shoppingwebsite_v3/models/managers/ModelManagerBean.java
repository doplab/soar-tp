package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "modelManager")
@SessionScoped
public class ModelManagerBean implements Serializable {

    @EJB
    ModelManagerSessionBeanRemote mmsbr;

    private String username = "";
    private String password = "";

    private String shopName = "";

    private double amount;

    private String foodName = "";
    private double foodPrice = 0;
    private String hasMeat = "";
    private String ingredientsBefore = "";

    private String drinkName = "";
    private double drinkPrice = 0;
    private String hasAlcohol = "";

    public ModelManagerBean() {
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

    public String getDrinkName() {
        return drinkName;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public String getIngredientsBefore() {
        return ingredientsBefore;
    }

    public String getHasAlcohol() {
        return hasAlcohol;
    }

    public String getHasMeat() {
        return hasMeat;
    }

    public double getAmount() {
        return amount;
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

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setHasAlcohol(String hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

    public void setHasMeat(String hasMeat) {
        this.hasMeat = hasMeat;
    }

    public void setIngredientsBefore(String ingredientsBefore) {
        this.ingredientsBefore = ingredientsBefore;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String userLogsIn() {
        return mmsbr.userLogsIn(username, password);
    }

    public String userLogsout() {
        return mmsbr.userLogsout();
    }
//    public String createAnAdmin() {
//        try {
//            if (isAdmin(currentUser) && !emailExists(adminBean.getEmail()) && !usernameExists(adminBean.getUsername())) {
//                userList.addAnAdmin(adminBean);
//            }
//        } catch (AlreadyExistsException | UnauthorizedActionException | DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
//    }
//    public String createABuyer() {
//        try {
//            if (!emailExists(buyerBean.getEmail()) && !usernameExists(buyerBean.getUsername())) {
//                userList.addABuyer(buyerBean);
//            }
//        } catch (AlreadyExistsException | DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/MainPage/MainPage.xhtml?faces-redirect=true";
//    }
//    public String createASeller() {
//        try {
//            if (!emailExists(sellerBean.getEmail()) && !usernameExists(sellerBean.getUsername())) {
//                userList.addASeller(sellerBean);
//            }
//        } catch (AlreadyExistsException | DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/MainPage/MainPage.xhtml?faces-redirect=true";
//    }
//    public String removeAnAdmin() {
//        try {
//            User u = findByUsername(username);
//            if (u != null) {
//                userList.removeAnAdmin(u);
//            }
//        } catch (DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
//    }
//    public String removeABuyer() {
//        try {
//            User user = findByUsername(username);
//            if (user != null) {
//                userList.removeABuyer(user);
//            }
//        } catch (DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
//    }
//    public String removeASeller() {
//        try {
//            User user = findByUsername(username);
//            if (user != null) {
//                userList.removeASeller(user);
//            }
//        } catch (DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
//    }

//    public String verifyAShop() {
//        try {
//            if (isAdmin(currentUser)) {
//                findSellerByShopName().setVerified(true);
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/AdminPage/AdminMainPage.xhtml?faces-redirect=true";
//    }
//    public SellerBean findSellerByShopName() throws DoesNotExistException {
//        for (User user : userList.getUsers()) {
//            if (user.getUsername().equals(shopName)) {
//                return (SellerBean) user;
//            }
//        }
//        throw new DoesNotExistException("The user " + shopName + " does not exist.");
//    }
//    public ArrayList<User> retreiveUsers() {
//        return userList.getUsers();
//    }
//    public ArrayList<AdminBean> retreiveAdmins() {
//        return userList.getAdmins();
//    }
//    public ArrayList<BuyerBean> retreiveBuyers() {
//        return userList.getBuyers();
//    }
//    public ArrayList<SellerBean> retreiveSellers() {
//        return userList.getSellers();
//    }
//    public String addADrinkToShop() {
//        try {
//            if (isSellerAuthorized(currentUser) && !doesDrinkExistInAShop(currentUser, drinkName, 'a')) {
//                drinkBean.setHasAcohol(hasAlcohol.equals("true") ? true : false);
//                ((SellerBean) currentUser).getDrinks().add(drinkBean);
//            }
//        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
//    }
//    public String addAFoodToShop() {
//        try {
//            if (isSellerAuthorized(currentUser) && !doesFoodExistInAShop(currentUser, foodName, 'a')) {
//                foodBean.setHasMeat(hasMeat.equals("true") ? true : false);
//                foodBean.getIngredients().addAll(Arrays.asList(ingredientsBefore.split(",")));
//                ((SellerBean) currentUser).getFoods().add(foodBean);
//            }
//        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
//    }
//    public String removeADrinkFromShop() {
//        try {
//            if (isSellerAuthorized(currentUser) && doesDrinkExistInAShop(currentUser, drinkName, 'r')) {
//                ((SellerBean) currentUser).getDrinks().remove(findADrinkByNameInAShop(currentUser, drinkName));
//            }
//        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
//    }
//    public String removeAFoodFromShop() {
//        try {
//            if (isSellerAuthorized(currentUser) && doesFoodExistInAShop(currentUser, foodName, 'r')) {
//                ((SellerBean) currentUser).getFoods().remove(findAFoodByNameInAShop(currentUser, foodName));
//            }
//        } catch (AlreadyExistsException | DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/SellerPage/SellerMainPage.xhtml?faces-redirect=true";
//    }
//    public String addADrinkToShoppingCart() {
//        try {
//            DrinkBean d = findADrinkByNameInAShop(findSellerByShopName(), drinkName);
//            if (isBuyerAuthorized(currentUser)) {
//                ((BuyerBean) currentUser).getShoppingCart().addADrink(d);
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
//    }
//    public String addAFoodToShoppingCart() {
//        try {
//            FoodBean f = findAFoodByNameInAShop(findSellerByShopName(), foodName);
//            if (isBuyerAuthorized(currentUser)) {
//                ((BuyerBean) currentUser).getShoppingCart().addAFood(f);
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
//    }
//    public String removeADrinkFromShoppingCart() {
//        try {
//            if (isBuyerAuthorized(currentUser) && doesDrinkExistInShoppingCart(currentUser, drinkName)) {
//                ((BuyerBean) currentUser).getShoppingCart().removeADrink(findADrinkByNameInAShoppingCart(currentUser, drinkName));
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
//    }
//    public String removeAFoodFromShoppingCart() {
//        try {
//            if (isBuyerAuthorized(currentUser) && doesFoodExistInShoppingCart(currentUser, foodName)) {
//                ((BuyerBean) currentUser).getShoppingCart().removeAFood(findAFoodByNameInAShoppingCart(currentUser, foodName));
//            }
//        } catch (DoesNotExistException | UnauthorizedActionException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
//    }
//    public String completePurchasement() {
//        try {
//            retrieveCurrentBuyer().completePurchasement();
//        } catch (InsufficientBalanceException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return "/BuyerPage/BuyerMainPage.xhtml?faces-redirect=true";
//    }
}
