package ch.unil.doplab.shoppingwebsite_v4.models;

import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Seller extends Users implements Serializable {

    private boolean verified;

    public Seller() {
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nVerified: " + this.isVerified();
    }

}
