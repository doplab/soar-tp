package ch.unil.doplab.shoppingwebsite_v4.models;

import ch.unil.doplab.shoppingwebsite_v4.Drinkable;
import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Drink extends Items implements Serializable, Drinkable {

    @Override
    public boolean containsAlcohol() {
        if (this.getHasMeatOrAlcohol().equals('t')) {
            return true;
        } else {
            return false;
        }
    }

}
