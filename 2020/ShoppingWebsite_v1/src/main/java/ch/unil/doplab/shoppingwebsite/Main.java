package ch.unil.doplab.shoppingwebsite;

import ch.unil.doplab.shoppingwebsite.controllers.ItemController;
import ch.unil.doplab.shoppingwebsite.controllers.UserController;
import ch.unil.doplab.shoppingwebsite.users.Admin;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;
import ch.unil.doplab.shoppingwebsite.views.ItemView;
import ch.unil.doplab.shoppingwebsite.views.UserView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Main {

    private static User currentUser;
    private static Scanner sc;

    static {
        createASampleDatabase();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the SOAR Shop!");
        homePage();
    }

    private static void homePage() {
        String choice, username, password, firstName, lastName, email, shopName;
        do {
            System.out.println("Enter:"
                    + "\n[q] to quit the application"
                    + "\n[1] to login"
                    + "\n[2] to create a new buyer account"
                    + "\n[3] to create a new seller account"
                    + "\n[4] to see products in a shop");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter your username:");
                    username = sc.nextLine();
                    System.out.println("Enter your password:");
                    password = sc.nextLine();
                    currentUser = UserController.userLogsIn(username, password);
                    if (currentUser instanceof Admin) {
                        UserView.adminHomePage(sc, currentUser);
                    } else if (currentUser instanceof Buyer) {
                        UserView.buyerHomePage(sc, currentUser);
                    } else if (currentUser instanceof Seller) {
                        UserView.sellerHomePage(sc, currentUser);
                    }
                    break;

                case "2":
                    System.out.println("Enter a username:");
                    username = sc.nextLine();
                    System.out.println("Enter a first name:");
                    firstName = sc.nextLine();
                    System.out.println("Enter a last name:");
                    lastName = sc.nextLine();
                    System.out.println("Enter an email:");
                    email = sc.nextLine();
                    System.out.println("Enter a password:");
                    password = sc.nextLine();
                    UserController.createABuyer(username, firstName, lastName, email, password);
                    break;
                case "3":
                    System.out.println("Enter a shop name:");
                    shopName = sc.nextLine();
                    System.out.println("Enter a first name:");
                    firstName = sc.nextLine();
                    System.out.println("Enter a last name:");
                    lastName = sc.nextLine();
                    System.out.println("Enter an email:");
                    email = sc.nextLine();
                    System.out.println("Enter a password:");
                    password = sc.nextLine();
                    UserController.createASeller(shopName, firstName, lastName, email, password);
                    break;
                case "4":
                    System.out.println("Enter the name of the shop you would like to see:");
                    shopName = sc.nextLine();
                    ItemView.printItemsInAShop(shopName);
                    break;
                case "q":
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
    }

    private static void createASampleDatabase() {
        // we need an admin to add another admin
        // thus, we add the first admin manually
        UserList.getInstance().addTheFirstAdmin(new Admin("lisa", "lisa", "simpson", "lisa@simpson.com", "1234"));

        // log in as an admin to add another admin
        currentUser = UserController.userLogsIn("lisa", "1234");
        UserController.createAnAdmin(currentUser, "homer", "homer", "simpson", "homer@simpson.com", "1234");

        UserController.createABuyer("marge", "marge", "simpson", "marge@simpson.com", "1234");
        UserController.createASeller("Barty's", "bart", "simpson", "bart@simpson.com", "1234");

        // log in as a seller to add foods and drinks
        currentUser = UserController.userLogsIn("Barty's", "1234");
        ItemController.addAFoodToShop(currentUser, "Pasta", 15.0, false, new ArrayList<String>() {
            {
                add("spaghetti");
                add("pesto sauce");
                add("parmigiano");
            }
        });
        ItemController.addAFoodToShop(currentUser, "Pizza", 12.0, false, new ArrayList<String>() {
            {
                add("dough");
                add("tomato sauce");
                add("mozarella");
            }
        });
        ItemController.addAFoodToShop(currentUser, "Chicken Curry", 18.0, true, new ArrayList<String>() {
            {
                add("chicken");
                add("curry sauce");
            }
        });
        ItemController.addADrinkToShop(currentUser, "Water", 1.0, false);
        ItemController.addADrinkToShop(currentUser, "Ice Tea", 2.0, false);
        ItemController.addADrinkToShop(currentUser, "Vodka", 5.0, true);
    }

}
