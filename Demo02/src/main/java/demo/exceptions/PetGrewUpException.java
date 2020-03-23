package demo.exceptions;

/**
 * The class indicates when pet age more than MAX_AGE
 * that a might to catch exception.
 */
public class PetGrewUpException extends Exception {

    public PetGrewUpException(String message) {
        super(message);
    }

}
