package ch.unil.doplab.shoppingwebsite_v3.models;

import ch.unil.doplab.shoppingwebsite_v3.exceptions.InsufficientBalanceException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "buyerBean")
@SessionScoped
public class BuyerBean extends User implements Serializable {

    private double balance = 0;
    private ShoppingCartBean shoppingCartBean = new ShoppingCartBean();

    public BuyerBean() {
    }

    public void completePurchasement() throws InsufficientBalanceException {
        if (this.balance >= shoppingCartBean.getBalance()) {
            System.out.println("You bought foods=" + Arrays.toString(shoppingCartBean.getFoods().toArray()) + ", drinks=" + Arrays.toString(shoppingCartBean.getDrinks().toArray()) + ".");
            balance -= shoppingCartBean.emptyShoppingCart();
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

    public ShoppingCartBean getShoppingCart() {
        return shoppingCartBean;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBalance: " + this.getBalance();
    }

}
