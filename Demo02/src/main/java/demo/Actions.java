package demo;

import demo.exceptions.*;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException;

    void toPlay() throws PetGrewUpException, PetDiedException;

    void toScold() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException;

    void toStroke() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException;

    void toWash() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException;

    void toHeal() throws PetGrewUpException, PetDiedException;
}
