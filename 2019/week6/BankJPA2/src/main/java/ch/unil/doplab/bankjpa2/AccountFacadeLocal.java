/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.bankjpa2;

import ch.unil.doplab.bankjpa2.entities.Account;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface AccountFacadeLocal {

    Account openAccount(String lasttName, String firstName);
    Account findAccount(long accountID);
    double deposit(long accountID, double amount);
    double withdraw(long accountID, double amount);
    
}
