package ch.unil.doplab.shoppingwebsite.exceptions;

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

    public String getMessage() {
        return message;
    }
}
