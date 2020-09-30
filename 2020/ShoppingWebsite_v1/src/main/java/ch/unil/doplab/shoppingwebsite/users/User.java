package ch.unil.doplab.shoppingwebsite.users;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public abstract class User {

    protected int id;
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected int password;
    private static int count = 0;

    public User(String username, String firstName, String lastName, String email, String password) {
        this.id = ++count;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password.hashCode();
    }

    public int getId() {
        return id;
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
        this.password = password.hashCode();
    }

    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId()
                + "\nUsername: " + this.getUsername()
                + "\nFirst Name: " + this.getFirstName()
                + "\nLast Name: " + this.getLastName()
                + "\nEmail: " + this.getEmail();
    }

}
