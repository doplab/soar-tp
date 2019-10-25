/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.bankjpa2;

import ch.unil.doplab.bankjpa2.entities.Account;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @Resource
    SessionContext context;
    
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
     @Override
    public Account openAccount(String lastName, String firstName) {
        Account account = new Account(lastName, firstName);
        System.out.println("before persisting ->" + account);
        em.persist(account);
        System.out.println("after persisting ->" + account);
        return account;
    }

    @Override
    public double deposit(long accountID, double amount) {
        Account account = em.find(Account.class, accountID);
        return account.deposit(amount);
    }

    @Override
    public double withdraw(long accountID, double amount) {
        Account account = em.find(Account.class, accountID);
        if (account.getBalance() - amount < 0) {
            context.setRollbackOnly();
            throw new IllegalArgumentException("insufficient balance");
        }
        return account.withdraw(amount);
    }

    @Override
    public Account findAccount(long accountID) {
        return em.find(Account.class, accountID);
    }
    
}
