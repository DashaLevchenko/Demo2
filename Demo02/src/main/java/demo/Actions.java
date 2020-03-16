package demo;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException;

    void toPlay() throws PetGrewUpException, PetDiedException;

    void toScold() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException;

    void toStroke() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException;

    void toWash() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException;

    void toHeal() throws PetGrewUpException, PetDiedException;
}
