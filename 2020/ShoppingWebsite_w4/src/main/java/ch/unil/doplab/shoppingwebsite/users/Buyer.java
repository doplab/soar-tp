package ch.unil.doplab.shoppingwebsite.users;

import ch.unil.doplab.shoppingwebsite.exceptions.InsufficientBalanceException;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Buyer extends User {

    private double balance;
    private ShoppingCart shoppingCart;

    public Buyer(String username, String firstName, String lastName, String email, String password) {
        super(username, firstName, lastName, email, password);
        this.balance = 0;
        this.shoppingCart = new ShoppingCart();
    }

    public void completePurchasement() throws InsufficientBalanceException {
        if (this.balance >= shoppingCart.getBalance()) {
            System.out.println("You bought foods=" + Arrays.toString(shoppingCart.getFoods().toArray()) + ", drinks=" + Arrays.toString(shoppingCart.getDrinks().toArray()) + ".");
            balance -= shoppingCart.emptyShoppingCart();
        } else {
            throw new InsufficientBalanceException("Balance is not enough.");
        }
    }

    public void increaseBalance(double balance) {
        this.balance += balance;
    }

    public void decreaseBalance(double balance) {
        this.balance -= balance;
    }

    public double getBalance() {
        return balance;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBalance: " + this.getBalance();
    }

}
