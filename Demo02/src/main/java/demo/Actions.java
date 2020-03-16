package demo;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException;

    void toPlay() throws PetGrewUpException, PetDiedException;

    void toScold() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException;

    void toStroke() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException;

    void toWash() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException;

    void toHeal() throws PetGrewUpException, PetDiedException;
}
