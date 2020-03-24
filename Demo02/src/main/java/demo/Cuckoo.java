package demo;


import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

import java.util.Random;


/**
 * Class of pet.
 */
public class Cuckoo extends Animal {

    public Cuckoo(String name) {
        super(name);
    }

    /**
     * Pet print it sound.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String makeSound() throws PetGrewUpException, PetDiedException {
        String sound = "Cuckoooo";
        return sound;
    }

    /**
     * Pet run away.
     *
     * @return message with action
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String flyAway() throws PetGrewUpException, PetDiedException {
        String message = "I was offended. Goodbye!";
        return message;
    }

    /**
     * Ask pet how long are you live.
     *
     * @param age take pet age
     * @return message and random age
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String countAge(int age) throws PetDiedException, PetGrewUpException {
        Random random = new Random();
        String message = "You will lived: ";
        age = age + random.nextInt(80);
        return message + age;
    }

    /**
     * Pet lay eggs, else make sound.
     *
     * @return method makeSound()
     * @throws PetGrewUpException when pet age more than MAX_AGE
     * @throws PetDiedException   when pet health point less then 0
     */
    public String layAnEgg(boolean egg) throws PetGrewUpException, PetDiedException {
        if (egg) {
            return flyAway();
        }
        return makeSound();
    }
}
