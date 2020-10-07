package ch.unil.doplab.shoppingwebsite.controllers;

import ch.unil.doplab.shoppingwebsite.UserList;
import ch.unil.doplab.shoppingwebsite.exceptions.AlreadyExistsException;
import ch.unil.doplab.shoppingwebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.shoppingwebsite.items.Drink;
import ch.unil.doplab.shoppingwebsite.items.Food;
import ch.unil.doplab.shoppingwebsite.users.Admin;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class ItemControllerTest {

    public ItemControllerTest() {
        System.out.println("ItemControllerTest constructor");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("@BeforeClass setUpClass");
        // we initialize our UserList (database for users) and add users to it
        // same as what we have in Main.java
        UserList.getInstance().addTheFirstAdmin(new Admin("lisa", "lisa", "simpson", "lisa@simpson.com", "1234"));
        User currentUser = UserController.userLogsIn("lisa", "1234");
        UserController.createAnAdmin(currentUser, "homer", "homer", "simpson", "homer@simpson.com", "1234");
        UserController.createABuyer("marge", "marge", "simpson", "marge@simpson.com", "1234");
        UserController.createASeller("Barty's", "bart", "simpson", "bart@simpson.com", "1234");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("@AfterClass tearDownClass");
        UserList.getInstance().getUsers().clear();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod setUp");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod tearDown");
    }

    @Test
    public void testAddADrinkToShop() throws DoesNotExistException, AlreadyExistsException {
        System.out.println("@Test testAddADrinkToShop");
        // login as a seller
        Seller seller = (Seller) UserController.userLogsIn("Barty's", "1234");
        // we need some mock data
        String drinkName = "Lemonade";
        double drinkPrice = 5.0;
        boolean containsAlcohol = false;
        // add it to the shop
        ItemController.addADrinkToShop(seller, drinkName, drinkPrice, containsAlcohol);
        // find the drink in the shop
        Drink expectedDrink = null;
        for (Drink d : seller.getDrinks()) {
            if (d.getName().equals(drinkName)) {
                expectedDrink = d;
            }
        }
        // if the drink exists, expectedDrink must have a value
        Assert.assertNotNull(expectedDrink);
    }

    @Test
    public void testRemoveADrinkFromShop() throws DoesNotExistException {
        System.out.println("@Test testRemoveADrinkFromShop");
        // login as a seller
        Seller seller = (Seller) UserController.userLogsIn("Barty's", "1234");
        // we need some mock data
        String drinkName = "Lemonade";
        // remove the drink
        ItemController.removeADrinkFromShop(seller, drinkName);
        // it should not exist in the shop
        Drink expectedDrink = null;
        for (Drink d : seller.getDrinks()) {
            if (d.getName().equals(drinkName)) {
                expectedDrink = d;
            }
        }
        // if the drink does not exist, expectedDrink must be null
        Assert.assertNull(expectedDrink);
    }

    @Test
    public void testAddADrinkToShoppingCart() throws DoesNotExistException {
        System.out.println("@Test addADrinkToShoppingCart");
        // login as a buyer
        Buyer buyer = (Buyer) UserController.userLogsIn("marge", "1234");
        // we need some mock data
        String shopName = "Barty's";
        String drinkName = "Lemonade";
        // add the drink to the shopping cart
        ItemController.addADrinkToShoppingCart(buyer, shopName, drinkName);
        // find the drink in the shopping cart
        Drink expectedDrink = null;
        for (Drink d : buyer.getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                expectedDrink = d;
            }
        }
        // if the drink exists, expectedDrink must have a value
        Assert.assertNotNull(expectedDrink);
    }

    @Test
    public void testRemoveADrinkFromShoppingCart() throws DoesNotExistException {
        System.out.println("@Test removeADrinkFromShoppingCart");
        // login as a buyer
        Buyer buyer = (Buyer) UserController.userLogsIn("marge", "1234");
        // we need some mock data
        String drinkName = "Lemonade";
        // remove the drink
        ItemController.removeADrinkFromShoppingCart(buyer, drinkName);
        // find the drink in the shopping cart
        Drink expectedDrink = null;
        for (Drink d : buyer.getShoppingCart().getDrinks()) {
            if (d.getName().equals(drinkName)) {
                expectedDrink = d;
            }
        }
        // if the drink does not exist, expectedDrink must be null
        Assert.assertNull(expectedDrink);
    }

    // test IndexOutOfBoundsException
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        System.out.println("@Test testIndexOutOfBoundsException");
        UserList.getInstance().getUsers().get(100);
    }

    // test timeout
    @Test(timeOut = 1000)
    public void testTimeOut() throws InterruptedException {
        System.out.println("@Test testTimeOut");
        Thread.sleep(500);
    }

    @Test
    public void testAddAFoodToShop() throws DoesNotExistException, AlreadyExistsException {
        System.out.println("@Test testAddAFoodToShop");
        // login as a seller
        Seller seller = (Seller) UserController.userLogsIn("Barty's", "1234");
        // we need some mock data
        String foodName = "Souffle";
        double foodPrice = 11.0;
        boolean containsMeat = false;
        // add it to the shop
        ItemController.addAFoodToShop(seller, foodName, foodPrice, containsMeat, new ArrayList() {
            {
                add("flour");
                add("coco powder");
                add("milk");
                add("egg");
                add("sugar");
            }
        });
        // find the food in the shop
        Food expecedFood = null;
        for (Food f : seller.getFoods()) {
            if (f.getName().equals(foodName)) {
                expecedFood = f;
            }
        }
        // if the food exists, expecedFood must have a value
        Assert.assertNotNull(expecedFood);
    }

    @Test
    public void testRemoveAFoodFromShop() throws DoesNotExistException {
        System.out.println("@Test testRemoveAFoodFromShop");
        // login as a seller
        Seller seller = (Seller) UserController.userLogsIn("Barty's", "1234");
        // we need some mock data
        String foodName = "Souffle";
        // remove the food
        ItemController.removeAFoodFromShop(seller, foodName);
        // it should not exist in the shop
        Food expectedFood = null;
        for (Food f : seller.getFoods()) {
            if (f.getName().equals(foodName)) {
                expectedFood = f;
            }
        }
        // if the food does not exist, expectedFood must be null
        Assert.assertNull(expectedFood);
    }

    @Test
    public void testAddAFoodToShoppingCart() throws DoesNotExistException {
        System.out.println("@Test testAddAFoodToShoppingCart");
        // login as a buyer
        Buyer buyer = (Buyer) UserController.userLogsIn("marge", "1234");
        // we need some mock data
        String shopName = "Barty's";
        String foodName = "Souffle";
        // add the food to the shopping cart
        ItemController.addAFoodToShoppingCart(buyer, shopName, foodName);
        // find the food in the shopping cart
        Food expectedFood = null;
        for (Food f : buyer.getShoppingCart().getFoods()) {
            if (f.getName().equals(foodName)) {
                expectedFood = f;
            }
        }
        // if the food exists, expectedFood must have a value
        Assert.assertNotNull(expectedFood);
    }

    @Test
    public void testRemoveAFoodFromShoppingCart() throws DoesNotExistException {
        System.out.println("@Test testRemoveAFoodFromShoppingCart");
        // login as a buyer
        Buyer buyer = (Buyer) UserController.userLogsIn("marge", "1234");
        // we need some mock data
        String foodName = "Souffle";
        // remove the food
        ItemController.removeAFoodFromShoppingCart(buyer, foodName);
        // it should not exist in the shopping cart
        Food expectedFood = null;
        for (Food f : buyer.getShoppingCart().getFoods()) {
            if (expectedFood.getName().equals(foodName)) {
                expectedFood = f;
            }
        }
        // if the food does not exist, expectedFood must be null
        Assert.assertNull(expectedFood);
    }

    // this test fails
    @Test(timeOut = 10)
    public void testFailingTimeOut() throws InterruptedException {
        System.out.println("@Test failTimeOut");
        Thread.sleep(500);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testNumberFormatException() {
        System.out.println("@Test testNumberFormatException");
        int n = Integer.parseInt(null);
    }

    @Test(expectedExceptions = ClassCastException.class)
    public void testClassCastException() {
        System.out.println("@Test testClassCastException");
        Object o = Integer.valueOf(42);
        String s = (String) o;

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testArithmeticException() {
        System.out.println("@Test testArithmeticException");
        int result = 7 / 0;
    }
}
