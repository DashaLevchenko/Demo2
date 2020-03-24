package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

/**
 * Class of pet.
 */
public class Parrot extends Animal {
    public Parrot(String name) {
        super(name);
    }

    /**
     * Pet is sad.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String toSing() throws PetGrewUpException, PetDiedException {
        String message = "I feel sad. Time to sing!";
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
        String message = "Something delicious smells... Is it my snacks?";
        return message;
    }

    /**
     * Pet flies.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String toFly() throws PetGrewUpException, PetDiedException {
        String message = "Hoorah, I am free!";
        return message;
    }
}
