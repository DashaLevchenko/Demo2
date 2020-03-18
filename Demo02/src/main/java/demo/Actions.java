package demo;

import demo.exceptions.*;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toPlay() throws PetGrewUpException, PetDiedException;

    void toScold() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toStroke() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toWash() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toHeal() throws PetGrewUpException, PetDiedException;
}
