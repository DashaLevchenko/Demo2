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
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String smile() throws PetGrewUpException, PetDiedException {
        String message = "Quokka always happy :))))))";
        return message;
    }

    /**
     * Pet make photo with human.
     *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String photoWithHuman() throws PetGrewUpException, PetDiedException {
        String message = "Click photo";
        smile();
        return message;
    }

    /**
     * Pet jump.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String toJump() throws PetGrewUpException, PetDiedException {
        String message = "Jump!!";
        return message;
    }
}
