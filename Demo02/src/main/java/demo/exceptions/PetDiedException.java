package demo.exceptions;

/**
 * The class indicates when pet point less then 0
 * that a might to catch exception.
 */
public class PetDiedException extends Exception {

    public PetDiedException(String message) {
        super(message);
    }

}
