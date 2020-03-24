package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

/**
 * Class of pet.
 */
public class Quokka extends Animal {
    public Quokka(String name) {
        super(name);
    }

    /**
     * Pet is happy.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String smile() throws PetGrewUpException, PetDiedException {
        String message = "Quokka always happy :))))))";
        return message;
    }

    /**
     * Pet make photo with human.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String photoWithHuman() throws PetGrewUpException, PetDiedException {
        String message = "Click photo";
        smile();
        return message;
    }

    /**
     * Pet jump.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String toJump() throws PetGrewUpException, PetDiedException {
        String message = "Jump!!";
        return message;
    }
}
