package demo;

public class PetNeedsSomethingException extends Exception {
    PetNeedsSomethingException(Animal animal) throws PetIsHungryException, PetIsIllException, PetIsDirtyException, PetWantsToPalyException, PocheshiPuzikoException, OopsYourShoesIsWetException {
        super();

        if (animal.getSatiety() < 10) {
            throw new PetIsHungryException("I'm hungry!");
        }
        if (animal.getisItSick() && animal.getHealthPoint() < 20) {
            throw new PetIsIllException("Something wrong, I'm feeling bad...");
        }
        if (animal.getPurity() <= 6) {
            throw new PetIsDirtyException("I'm dirty. You know what to do!)");
        }
        if (animal.getHappiness() < 5) {
            throw new PetWantsToPalyException("Play with me or your shoes will suffer!");
        }
        if (animal.getHappiness() < 7) {
            throw new PocheshiPuzikoException("Purrr! Scratch my tummy!");
        }
        if (animal.getHappiness() < 4 || animal.getSatiety() < 15) {
            throw new OopsYourShoesIsWetException("Oops! Your shoes is wet...");
        }

}
}