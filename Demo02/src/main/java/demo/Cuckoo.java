package demo;


import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

import java.util.Random;


/**
 * Class of pet.
 */
public class Cuckoo extends Animal{

    public Cuckoo(String name) {
        super(name);
    }

    /**
     * Pet print it sound.
     *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String makeSound() throws PetGrewUpException, PetDiedException {
        String sound = "Cuckoooo";
        return sound;
    }

    /**
     * Pet run away.
     *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String flyAway() throws PetGrewUpException, PetDiedException {
        String message = "I was offended. Goodbye!";
        return message;
    }

    /**
     * Ask pet how long are you live.
     *
     * @param age
     * @throws PetGrewUpException
     * @throws PetDiedException
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
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String layAnEgg(boolean egg) throws PetGrewUpException, PetDiedException {
        if (egg){
            return flyAway();
        }
        return makeSound();
    }
}
