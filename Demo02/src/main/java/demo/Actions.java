package demo;

public interface Actions {
    void toFeed() throws PetGrewUpException, PetDiedException;

    void toPlay();

    void toScold() throws PetGrewUpException, PetDiedException;

    void toStroke() throws PetGrewUpException, PetDiedException;

    void toWash() throws PetGrewUpException, PetDiedException;

    void toHeal();
}
