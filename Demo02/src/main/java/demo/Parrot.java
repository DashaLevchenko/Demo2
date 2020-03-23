package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

/**
 * Class of pet.
 */
public class Parrot extends Animal {
    public Parrot (String name) {
        super(name);
    }
    
    /**
     * Pet is sad.
     *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String toSing() throws PetGrewUpException, PetDiedException {
        String message = "I feel sad. Time to sing!";
        return message;
    }

    
    /*** Pet eats.
     * *
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    public String toEat() throws PetGrewUpException, PetDiedException {
        String message = "Something delicious smells... Is it my snacks?";
        return message;
        }
        /**
         * Pet flies.
         *
         * @return
         * @throws PetGrewUpException
         * @throws PetDiedException
         */
        public String toFly() throws PetGrewUpException, PetDiedException {
            String message = "Hoorah, I am free!";
            return message;
        }
}
