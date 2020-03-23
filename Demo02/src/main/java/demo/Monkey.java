package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

public class Monkey extends Animal {
   public Monkey(String name){
        super(name);
    }

    @Override
    public String toWashDishes() throws PetGrewUpException, PetDiedException {
        return super.toWashDishes();
    }

    @Override
    public String toDance() throws PetGrewUpException, PetDiedException {
        return super.toDance();
    }

    @Override
    public String toFeed() throws PetGrewUpException, PetDiedException {
       return checkNextAction();
    }

    @Override
    public String toPlay() throws PetGrewUpException, PetDiedException {
        return super.toPlay();
    }

    @Override
    public String toWash() throws PetDiedException, PetGrewUpException {
        return super.toWash();
    }
}
