package ch.unil.doplab.shoppingwebsite_v3.models;

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
