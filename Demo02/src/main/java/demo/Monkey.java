package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

/**
 * Class of pet.
 */
public class Monkey extends Animal {
    public Monkey(String name) {
        super(name);
    }

    /**
     * Pet washes up.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String toWashDishes() throws PetGrewUpException, PetDiedException {
        String message = "Oh no, dirty dishes again!";
        return message;
    }


    /**
     * Pet dances.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String toDance() throws PetGrewUpException, PetDiedException {
        String message = "Everybody dance now!";
        return message;
    }

    /**
     * Pet eats.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String toEat() throws PetGrewUpException, PetDiedException {
        String message = "Mmm, time to fill in my belly";
        return message;
    }
}
