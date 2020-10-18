package ch.unil.doplab.shoppingwebsite_v2.models;

import ch.unil.doplab.shoppingwebsite_v2.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean extends User implements Serializable {

    public AdminBean() {
    }

}
