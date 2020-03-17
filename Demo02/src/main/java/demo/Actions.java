package demo;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PocheshiPuzikoException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toPlay() throws PetGrewUpException, PetDiedException;

    void toScold() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PocheshiPuzikoException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toStroke() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PocheshiPuzikoException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toWash() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PocheshiPuzikoException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException;

    void toHeal() throws PetGrewUpException, PetDiedException;
}
