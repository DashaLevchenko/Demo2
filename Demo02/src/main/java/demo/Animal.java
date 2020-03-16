package demo;


public abstract class Animal implements Actions {
    public static final int MAX_AGE = 5;
    public static final int MAX_HEALTH_POINT = 50;
    public static final int MAX_HAPPINESS = 10;
    public static final int MAX_SATIETY = 50;
    public static final int MAX_PURITY = 10;
    public static final int MIN_HEALTH_POINT = 0;

    private int healthPoint;
    private int happiness;
    private int satiety;
    private double age;
    private int purity;
    private boolean isItSick;


    public Animal() {
        healthPoint = 25;
        happiness = 5;
        satiety = 25;
        age = 0;
        purity = 0;
        isItSick = false;
    }

    @Override
    public void toFeed() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException {
        changeHealthPoint(2, true);//add methods increase health
        happiness += 1;
        satiety += 10;
        age += 0.2;
        purity -= 2;
        check_stage(); //have to be static...

    }

    @Override
    public void toPlay() throws PetGrewUpException, PetDiedException {
//some code
    }

    @Override
    public void toScold() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException {
        changeHealthPoint(2, false);
        healthPoint -= 2;
        happiness -= 2;
        satiety -= 1;
        age += 0.2;
        check_stage();
    }

    /**
     * This method changes field {@code healthPoint}.
     * If add true, digit will added to {@code healthPoint},
     * else digit will subscribe
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changeHealthPoint(int digit, boolean add) {
        if (healthPoint < MAX_HEALTH_POINT) {
            if (add) {
                healthPoint += digit;
            }else{
                healthPoint -= digit;
            }
        }
    }

    @Override
    public void toStroke() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException {
        changeHealthPoint(2, false);
        happiness += 2;
        satiety -= 1;
        age += 0.2;
        check_stage();
    }

    @Override
    public void toWash() throws PetGrewUpException, PetDiedException, PocheshiPuzikoException, PetWantsToPalyException, PetIsDirtyException, PetIsIllException, PetIsHungryException {
        changeHealthPoint(2, true);
        satiety -= 1;
        age += 0.2;
        purity += 3;
        check_stage();
    }

    @Override
    public void toHeal() throws PetGrewUpException, PetDiedException {

    }

    public void check_stage() throws PetDiedException, PetGrewUpException, PetIsHungryException, PetIsDirtyException, PetIsIllException, PetWantsToPalyException, PocheshiPuzikoException {
        if (healthPoint <= MIN_HEALTH_POINT) {
            throw new PetDiedException("Your pet is dead. Game over.");
        }
        if (age > MAX_AGE) {
            throw new PetGrewUpException("Congratulations! Your pet has been grew up! \n Game over.");
        }
    }


    public int getHealthPoint() {
        return healthPoint;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getSatiety() {
        return satiety;
    }

    public double getAge() {
        return age;
    }

    public int getPurity() {
        return purity;
    }


}
