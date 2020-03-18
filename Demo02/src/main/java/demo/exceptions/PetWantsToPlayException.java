package demo.exceptions;

public class PetWantsToPlayException extends Exception {
    public PetWantsToPlayException(String message) {
        super(message);
    }
}
