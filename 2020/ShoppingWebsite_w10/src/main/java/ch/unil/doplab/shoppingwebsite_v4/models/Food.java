package ch.unil.doplab.shoppingwebsite_v4.models;

import ch.unil.doplab.shoppingwebsite_v4.Edible;
import java.io.Serializable;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class Food extends Items implements Serializable, Edible {

    @Override
    public boolean containsMeat() {
        if (this.getHasMeatOrAlcohol().equals('t')) {
            return true;
        } else {
            return false;
        }
    }
}
