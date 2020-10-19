package ch.unil.doplab.shoppingwebsite_v3.exceptions;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
public class InsufficientBalanceException extends Exception {

    private String message;

    public InsufficientBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
