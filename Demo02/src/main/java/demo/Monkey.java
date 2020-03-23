package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

public class Monkey extends Animal {
   public Monkey(String name){
        super(name);
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
