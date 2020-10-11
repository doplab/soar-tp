package ch.unil.doplab.shoppingwebsite_v2.beans.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Named(value = "itemControllerBean")
@SessionScoped
public class ItemControllerBean implements Serializable {

    public ItemControllerBean() {
    }

}
