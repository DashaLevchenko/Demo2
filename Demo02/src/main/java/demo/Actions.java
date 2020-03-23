package demo;

import demo.exceptions.*;

public interface Actions {

    String toFeed() throws PetGrewUpException, PetDiedException;

    String toPlay() throws PetGrewUpException, PetDiedException;

    String toScold() throws PetGrewUpException, PetDiedException;

    String toStroke() throws PetGrewUpException, PetDiedException;

    String toWash() throws PetGrewUpException, PetDiedException;

    String toHeal() throws PetGrewUpException, PetDiedException;

    String toSing() throws PetGrewUpException, PetDiedException;

    String toDance () throws PetGrewUpException, PetDiedException;

    String toWashDishes() throws PetGrewUpException, PetDiedException;


}
