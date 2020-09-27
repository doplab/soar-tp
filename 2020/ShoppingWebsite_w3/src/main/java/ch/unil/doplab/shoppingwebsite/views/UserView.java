package ch.unil.doplab.shoppingwebsite.views;

import ch.unil.doplab.shoppingwebsite.UserList;
import ch.unil.doplab.shoppingwebsite.controllers.ItemController;
import ch.unil.doplab.shoppingwebsite.controllers.UserController;
import ch.unil.doplab.shoppingwebsite.exceptions.InsufficientBalanceException;
import ch.unil.doplab.shoppingwebsite.users.Admin;
import ch.unil.doplab.shoppingwebsite.users.Buyer;
import ch.unil.doplab.shoppingwebsite.users.Seller;
import ch.unil.doplab.shoppingwebsite.users.User;
import ch.unil.doplab.shoppingwebsite.items.Drink;
// TODO/Food : uncomment
//import ch.unil.doplab.shoppingwebsite.items.Food;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class UserView {

    public static void adminHomePage(Scanner sc, User currentUser) {
        Admin admin = (Admin) currentUser;
        String choice, username, password, firstName, lastName, email, shopName;
        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to create an admin"
                    + "\n[2] to remove an admin"
                    + "\n[3] to verify a shop"
                    + "\n[4] to show all admins"
                    + "\n[5] to show all buyers"
                    + "\n[6] to show all sellers"
                    + "\n[7] to show all users"
                    + "\n[8] to show user information");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
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
                    UserController.createAnAdmin(admin, username, firstName, lastName, email, password);
                    break;
                case "2":
                    System.out.println("Enter a username:");
                    username = sc.nextLine();
                    UserController.removeAnAdmin(username);
                    break;
                case "3":
                    System.out.println("Enter a shop name");
                    shopName = sc.nextLine();
                    UserController.verifyAShop(admin, shopName);
                    break;
                case "4":
                    printAllAdmins();
                    break;
                case "5":
                    printAllBuyers();
                    break;
                case "6":
                    printAllSellers();
                    break;
                case "7":
                    printAllUsers();
                    break;
                case "8":
                    System.out.println(admin.toString());
                    break;
                case "q":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
    }

    public static void buyerHomePage(Scanner sc, User currentUser) {
        Buyer buyer = (Buyer) currentUser;
        String choice, shopName, subChoice, foodName, drinkName;
        double newBalance;
        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to see products in a shop and add products"
                    + "\n[2] to remove a food from the shopping cart"
                    + "\n[3] to remove a drink from the shopping cart"
                    + "\n[4] to see products in the shopping cart"
                    + "\n[5] to deposit money to account"
                    + "\n[6] to complete purchasement"
                    + "\n[7] to show user information");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the name of the shop you would like to see:");
                    shopName = sc.nextLine();
                    ItemView.printItemsInAShop(shopName);
                    do {
                        System.out.println("Enter: "
                                + "\n[q] to go back"
                                + "\n[1] to add a food from shop to the shopping cart"
                                + "\n[2] to add a drink from shop to the shopping cart");
                        subChoice = sc.nextLine();
                        switch (subChoice) {
                            case "1":
                                // TODO/Food : complete this case
                                System.err.println("THIS OPERATION IS NOT COMPLETE YET.");
                                break;
                            case "2":
                                System.out.println("Enter the name of the food:");
                                drinkName = sc.nextLine();
                                ItemController.addADrinkToShoppingCart(buyer, shopName, drinkName);
                                break;
                            case "q":
                                break;
                            default:
                                System.out.println("Choice = " + subChoice + " does not exist.");
                                break;
                        }
                    } while (!subChoice.equals("q"));
                    break;
                case "2":
                    // TODO/Food : complete this case
                    System.err.println("THIS OPERATION IS NOT COMPLETE YET.");
                    break;
                case "3":
                    System.out.println("Here are the products in the shopping cart, write the name of the drink you want to remove.");
                    System.out.println(buyer.getShoppingCart().toString());
                    System.out.println("Drink name:");
                    drinkName = sc.nextLine();
                    ItemController.removeADrinkFromShoppingCart(buyer, drinkName);
                    break;
                case "4":
                    System.out.println(buyer.getShoppingCart().toString());
                    break;
                case "5":
                    System.out.println("Enter the amount you want to deposit (double):");
                    newBalance = sc.nextDouble();
                    sc.nextLine(); // nextDouble() takes the double but does not consume the \n comes after the value, we must consume it
                    buyer.increaseBalance(newBalance);
                    break;
                case "6":
                    try {
                    buyer.completePurchasement();
                } catch (InsufficientBalanceException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case "7":
                    System.out.println(buyer.toString());
                    break;
                case "q":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
    }

    public static void sellerHomePage(Scanner sc, User currentUser) {
        Seller seller = (Seller) currentUser;
        String choice, foodName, drinkName, hasMeat, hasAlcohol, ingredients;
        double foodPrice, drinkPrice;
        boolean containsMeat = true, containsAlcohol = true;
        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to add a food to the shop"
                    + "\n[2] to add a drink to the shop"
                    + "\n[3] to remove a food from the shop"
                    + "\n[4] to remove a drink from the shop"
                    + "\n[5] to show all products in the shop"
                    + "\n[6] to show information");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    // TODO/Food : complete this case
                    System.err.println("THIS OPERATION IS NOT COMPLETE YET.");
                    break;
                case "2":
                    System.out.println("Enter the name of the drink:");
                    drinkName = sc.nextLine();
                    System.out.println("Enter the price of the drink (double):");
                    drinkPrice = sc.nextDouble();
                    sc.nextLine(); // nextDouble() takes the double but does not consume the \n comes after the value, we must consume it
                    System.out.println("Enter [n] if this drink does not contain alcohol, otherwise it will be assumed to have alcohol:");
                    hasAlcohol = sc.nextLine();
                    containsAlcohol = hasAlcohol.equals("n") ? false : true;
                    ItemController.addADrinkToShop(seller, drinkName, drinkPrice, containsAlcohol);
                    break;
                case "3":
                    // TODO/Food : complete this case
                    System.err.println("THIS OPERATION IS NOT COMPLETE YET.");
                    break;
                case "4":
                    System.out.println("Enter the name of the drink:");
                    drinkName = sc.nextLine();
                    ItemController.removeADrinkFromShop(seller, drinkName);
                    break;
                case "5":
                    System.out.println(seller.productsToString());
                    break;
                case "6":
                    System.out.println(seller.toString());
                    break;
                case "q":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
    }

    private static void printAllAdmins() {
        UserList.getInstance().getAdmins().forEach(admin -> System.out.println(admin.toString()));
    }

    private static void printAllBuyers() {
        UserList.getInstance().getBuyers().forEach(buyer -> System.out.println(buyer.toString()));
    }

    private static void printAllSellers() {
        UserList.getInstance().getSellers().forEach(seller -> System.out.println(seller.toString()));
    }

    private static void printAllUsers() {
        UserList.getInstance().getUsers().forEach(user -> System.out.println(user.toString()));
    }
}
