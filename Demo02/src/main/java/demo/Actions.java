package demo;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException, PetNeedsSomethingException;

    void toPlay() throws PetGrewUpException, PetDiedException;

    void toScold() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException, PetNeedsSomethingException;

    void toStroke() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException, PetNeedsSomethingException;

    void toWash() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException, OopsYourShoesIsWetException, PetNeedsSomethingException;

    void toHeal() throws PetGrewUpException, PetDiedException;
}
