package demo;


import demo.exceptions.*;

public abstract class Animal implements Actions {
    public static final int MAX_AGE = 5;
    public static final int MAX_HEALTH_POINT = 50;
    public static final int MAX_HAPPINESS = 10;
    public static final int MAX_SATIETY = 50;
    public static final int MAX_PURITY = 10;
    public static final int MIN_HEALTH_POINT = 0;


    private String name;
    private int healthPoint;
    private int happiness;
    private int satiety;
    private double age;
    private int purity;
    private boolean isItSick;


    public Animal(String name) {
        healthPoint = 25;
        happiness = 5;
        satiety = 25;
        age = 0;
        purity = 0;
        isItSick = false;
        this.name = name;
    }

    @Override
    public void toFeed() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException {
        changeHealthPoint(2, true);//add methods increase health
        changeHappiness(1, true);
        changeSatiety(10, true);
        changeAge();
        changePurity(2, false);
        checkStage(); //have to be static...

    }

    @Override
    public void toPlay() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException, PetWantsToScratchTummyException {
        changeHealthPoint(2, false);
        changeHappiness(4, true);
        changeSatiety(1, false);
        changeAge();
        changePurity(2, false);
        checkStage();
    }

    @Override
    public void toScold() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException {
        changeHealthPoint(2, false);
        changeHappiness(2, false);
        changeSatiety(1, false);

        changeAge();
        checkStage();
    }

    @Override
    public void toStroke() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException {
        changeHealthPoint(2, false);
        changeHappiness(2, true);
        changeSatiety(1, false);
        changeAge();
        checkStage();
    }

    @Override
    public void toWash() throws PetDiedException, PetGrewUpException, PetIsDirtyException, PetWantsToScratchTummyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException {
        changeHealthPoint(2, true);
        changeSatiety(1, false);
        changeAge();
        changePurity(5, true);
        checkStage();
    }


    @Override
    public void toHeal() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPlayException, PetWantsToScratchTummyException {
        changeHealthPoint(18, true);
        changeHappiness(2, false);
        changeSatiety(2, false);
        changeAge();
        changePurity(2, false);
        checkStage();
    }

    public void checkStage() throws PetDiedException, PetGrewUpException, PetIsHungryException, PetIsIllException, PetIsDirtyException, PetWantsToPlayException, PetWantsToScratchTummyException, OopsYourShoesIsWetException {
        if (healthPoint <= MIN_HEALTH_POINT) {
            throw new PetDiedException("Your pet is dead. Game over.");
        }
        if (age > MAX_AGE) {
            throw new PetGrewUpException("Congratulations! Your pet has been grew up! \n Game over.");
        }

        if (satiety < 10) {
            throw new PetIsHungryException("I'm hungry!");
        }
        if (isItSick && healthPoint < 20) {
            throw new PetIsIllException("Something wrong, I'm feeling bad...");
        }
        if (purity <= 6) {
            throw new PetIsDirtyException("I'm dirty. You know what to do!)");
        }
        if (happiness < 4 && satiety < 15) {
            throw new OopsYourShoesIsWetException("Oops! Your shoes is wet...");
        }
        if (happiness < 5) {
            throw new PetWantsToPlayException("Play with me or your shoes will suffer!");
        }
        if (happiness < 7) {
            throw new PetWantsToScratchTummyException("Purrr! Scratch my tummy!");
        }

    }

    /**
     * This method changes field {@code healthPoint}.
     * If add true, digit will added to {@code healthPoint},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changeHealthPoint(int digit, boolean add) {
        int newValue;

        if (add) {
            newValue = healthPoint + digit;
        } else {
            newValue = healthPoint - digit;
            if (newValue < 0) {
                newValue = 0;
            }
        }

        healthPoint = Math.min(newValue, MAX_HEALTH_POINT);
    }

    /**
     * This method changes field {@code happiness}.
     * If add true, digit will added to {@code happiness},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changeHappiness(int digit, boolean add) {
        int newValue;

        if (add) {
            newValue = happiness + digit;
        } else {
            newValue = happiness - digit;
            if (newValue < 0) {
                newValue = 0;
            }
        }

        happiness = Math.min(newValue, MAX_HAPPINESS);
    }

    /**
     * This method changes field {@code satiety}.
     * If add true, digit will added to {@code satiety},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changeSatiety(int digit, boolean add) {
        int newValue;

        if (add) {
            newValue = satiety + digit;
        } else {
            newValue = satiety - digit;
            if (newValue < 0) {
                newValue = 0;
            }
        }

        satiety = Math.min(newValue, MAX_SATIETY);
    }

    /**
     * This method changes field {@code purity}.
     * If add true, digit will added to {@code purity},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changePurity(int digit, boolean add) {
        int newValue;

        if (add) {
            newValue = purity + digit;
        } else {
            newValue = purity - digit;
            if (newValue < 0) {
                newValue = 0;
            }
        }
        purity = Math.min(newValue, MAX_PURITY);
    }

    private void changeAge() {
        if (age < MAX_AGE) {
            age += 0.2;
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

    public boolean getIsItSick() {
        return isItSick;
    }


    public String getName() {
        return name;
    }
}
