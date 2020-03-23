package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

/**
 * Class of pet.
 */
public class Monkey extends Animal {
    public Monkey (String name) {
        super(name);
    }

    /**
     * Pet washes up.
     *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String toWashDishes() throws PetGrewUpException, PetDiedException {
        String message = "Oh no, dirty dishes again!";
        return message;
    }


    /*** Pet dances.
     * *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String toDance() throws PetGrewUpException, PetDiedException {
        String message = "Everybody dance now!";
        return message;
    }

    /**
     * Pet eats.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String toEat() throws PetGrewUpException, PetDiedException {
        String message = "Mmm, time to fill in my belly";
        return message;
    }
}
