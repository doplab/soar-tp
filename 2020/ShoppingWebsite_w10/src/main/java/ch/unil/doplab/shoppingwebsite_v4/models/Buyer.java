package ch.unil.doplab.shoppingwebsite_v4.models;

import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Buyer extends Users implements Serializable {

    private double balance = 0;

    public Buyer() {
    }

    public void increaseBalance(double balance) {
        this.balance += balance;
    }

    public void decreaseBalance(double balance) {
        this.balance -= balance;
    }

    public Double getBalance() {
        return balance;
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
