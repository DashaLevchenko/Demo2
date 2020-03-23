package demo;

import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

public class Parrot extends Animal {
    public Parrot (String name){
        super(name);
    }


    @Override
    public String toFeed() throws PetGrewUpException, PetDiedException {
        return super.toFeed();
    }
}
