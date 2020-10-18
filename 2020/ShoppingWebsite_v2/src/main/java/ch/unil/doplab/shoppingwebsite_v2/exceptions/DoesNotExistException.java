package ch.unil.doplab.shoppingwebsite_v2.exceptions;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class DoesNotExistException extends Exception {

    private String message;

    public DoesNotExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
