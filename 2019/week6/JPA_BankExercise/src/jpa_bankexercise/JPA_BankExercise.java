package jpa_bankexercise;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Melike Geçer
 */
public class JPA_BankExercise {

    private static final String PERSISTENCE_UNIT_NAME = "JPA_BankExercisePU";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String command = "";

        while (!command.equals("exit")) {
            System.out.println("1 - create a new account");
            System.out.println("2 - print all accounts");
            System.out.println("3 - print all payments");
            System.out.println("4 - update an account");
            System.out.println("5 - deposit money to an account");
            System.out.println("6 - withdraw money from an account");
            System.out.println("7 - delete an account");
            System.out.println("type \"exit\" to quit");
            command = input.next();

            String firstName;
            String lastName;
            int id;
            double amount;
            switch (command) {
                //<editor-fold defaultstate="collapsed" desc="1 - create a new account">
                case "1":
                    System.out.println("-------------------------------------");
                    System.out.println("Please, type the first name of the client:");
                    firstName = input.next();
                    System.out.println("Please, type the last name of the client:");
                    lastName = input.next();
                    if (createNewAccount(firstName, lastName)) {
                        System.out.println("Account for " + firstName + " " + lastName + " is created.");
                    } else {
                        System.out.println("There's a problem. Account for " + firstName + " " + lastName + " couldn't be created.");
                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="2 - print all accounts">    
                case "2":
                    printAccounts();
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="3 - print all payments">
                case "3":
                    printPayments();
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="4 - update an account">
                case "4":
                    System.out.println("-------------------------------------");
                    System.out.println("Please, type the ID of the client:");
                    id = input.nextInt();
                    System.out.println("Please, type the new first name of the client:");
                    firstName = input.next();
                    System.out.println("Please, type the new last name of the client:");
                    lastName = input.next();
                    if (updateAccount(id, firstName, lastName)) {
                        System.out.println("Account for " + id + " successfully changed.");
                    } else {
                        System.out.println("There's a problem. Account for " + id + " can't be changed.");
                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="5 - deposit money to an account">
                case "5":
                    System.out.println("-------------------------------------");
                    System.out.println("Please, type the ID of the client:");
                    id = input.nextInt();
                    System.out.println("Please, type how much money you want to deposit:");
                    amount = input.nextDouble();
                    if (depositMoney(id, amount)) {
                        System.out.println(amount + " CHF is deposited to account " + id + ".");
                    } else {
                        System.out.println("There's a problem. " + amount + " couldn't be deposited.");
                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="6 - withdraw money from an account">
                case "6":
                    System.out.println("-------------------------------------");
                    System.out.println("Please, type the ID of the client:");
                    id = input.nextInt();
                    System.out.println("Please, type how much money you want to withdraw:");
                    amount = input.nextDouble();
                    if (withdrawMoney(id, amount)) {
                        System.out.println(amount + " CHF is withdrawn from the account " + id + ".");
                    } else {
                        System.out.println("There's a problem. " + amount + " couldn't be withdrawn.");
                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="7 - delete an account">
                case "7":
                    System.out.println("-------------------------------------");
                    System.out.println("Please, type the ID of the client:");
                    id = input.nextInt();
                    if (deleteAccount(id)) {
                        System.out.println("Account " + id + " is removed from the system.");
                    } else {
                        System.out.println("There's a problem. Account " + id + " couldn't be removed.");
                    }
                    break;
                //</editor-fold>
                case "exit":
                    break;
                default:
                    System.out.println("There's no such operation called " + command + ".");
                    break;
            }
        }
        closeEntityManager();
    }

    private static boolean createNewAccount(String firstName, String lastName) {
        try {
            Account a = new Account();
            em.getTransaction().begin();
            a.setFirstName(firstName);
            a.setLastName(lastName);
            a.setAccBalance(0.0);
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void printAccounts() {
        Query q2 = em.createQuery("SELECT a FROM Account a");
        List<Account> accountList = q2.getResultList();
        for (Account account : accountList) {
            System.out.println(account.toString());
        }
    }

    private static void closeEntityManager() {
        em.close();
    }

    private static void printPayments() {
        Query q3 = em.createQuery("SELECT p FROM Payment p");
        List<Payment> paymentList = q3.getResultList();
        for (Payment payment : paymentList) {
            System.out.println(payment.toString());
        }
    }

    private static boolean updateAccount(int id, String firstName, String lastName) {
        try {
            Account account = em.find(Account.class, id);
            em.getTransaction().begin();
            account.setFirstName(firstName);
            account.setLastName(lastName);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean depositMoney(int id, double amount) {
        try {
            // First, increase the balance in the account.
            Account account = em.find(Account.class, id);
            em.getTransaction().begin();
            account.setAccBalance(account.getAccBalance() + amount);
            em.getTransaction().commit();
            // Then, create a new payment and add it to DB.
            em.getTransaction().begin();
            Payment p = new Payment();
            p.setPayAmount(amount);
            p.setExecDate(new Date(System.currentTimeMillis()));
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean withdrawMoney(int id, double amount) {
        try {
            // First, decrease the balance in the account.
            Account account = em.find(Account.class, id);
            em.getTransaction().begin();
            account.setAccBalance(account.getAccBalance() - amount);
            em.getTransaction().commit();
            // Then, create a new payment and add it to DB.
            em.getTransaction().begin();
            Payment p = new Payment();
            p.setPayAmount(amount * -1);
            p.setExecDate(new Date(System.currentTimeMillis()));
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean deleteAccount(int id) {
        try {
            Account a = em.find(Account.class, id);
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
