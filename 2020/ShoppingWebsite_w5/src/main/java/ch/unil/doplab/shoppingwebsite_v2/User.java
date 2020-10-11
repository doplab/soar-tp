package ch.unil.doplab.shoppingwebsite_v2;

import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public abstract class User implements Serializable {

    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected int hashedPassword;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getHashedPassword() {
        return hashedPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
        this.hashedPassword = password.hashCode();
    }

    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.hashedPassword;
    }

    @Override
    public String toString() {
        return "Username: " + this.getUsername()
                + "\nFirst Name: " + this.getFirstName()
                + "\nLast Name: " + this.getLastName()
                + "\nEmail: " + this.getEmail();
    }

}
