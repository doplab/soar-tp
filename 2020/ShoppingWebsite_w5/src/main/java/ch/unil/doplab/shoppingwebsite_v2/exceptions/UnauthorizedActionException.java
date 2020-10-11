package ch.unil.doplab.shoppingwebsite_v2.exceptions;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class UnauthorizedActionException extends Exception {

    private String message;

    public UnauthorizedActionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
