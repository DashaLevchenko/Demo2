package demo;


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
    public void toFeed() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException {
        changeHealthPoint(2, true);//add methods increase health
        changeHappiness(1, true);
        changeSatiety(10, true);
        changeAge();
        changePurity(2, false);
        check_stage(); //have to be static...

    }

    @Override
    public void toPlay() throws PetGrewUpException, PetDiedException {
//some code
    }

    @Override
    public void toScold() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException {
        changeHealthPoint(2, false);
        changeHappiness(2, false);
        changeSatiety(1, false);

        changeAge();
        check_stage();
    }

    @Override
    public void toStroke() throws PetGrewUpException, PetDiedException, PetNeedsSomethingException {
        changeHealthPoint(2, false);
        changeHappiness(2, true);
        changeSatiety(1, false);
        changeAge();
        check_stage();
    }

    /**
     *
     * @throws PetDiedException
     * @throws PetGrewUpException
     * @throws PetNeedsSomethingException
     */
    @Override
    public void toWash() throws PetDiedException, PetGrewUpException, PetNeedsSomethingException {
        changeHealthPoint(2, true);
        changeSatiety(1, false);
        changeAge();
        changePurity(3, true);
        check_stage();
    }


    @Override
    public void toHeal() throws PetGrewUpException, PetDiedException {

    }

    public void check_stage() throws PetDiedException, PetGrewUpException, PetNeedsSomethingException {
        if (healthPoint <= MIN_HEALTH_POINT) {
            throw new PetDiedException("Your pet is dead. Game over.");
        }
        if (age > MAX_AGE) {
            throw new PetGrewUpException("Congratulations! Your pet has been grew up! \n Game over.");
        }

        if (getSatiety() < 10) {
            throw new PetNeedsSomethingException("I'm hungry!");
        }
        if (getisItSick() && getHealthPoint() < 20) {
            throw new PetNeedsSomethingException("Something wrong, I'm feeling bad...");
        }
        if (getPurity() <= 6) {
            throw new PetNeedsSomethingException("I'm dirty. You know what to do!");
        }
        if (getHappiness() < 5) {
            throw new PetNeedsSomethingException("Play with me or your shoes will suffer!");
        }
        if (getHappiness() < 7) {
            throw new PetNeedsSomethingException("Purrr! Scratch my tummy!");
        }
        if (getHappiness() < 4 || getSatiety() < 15) {
            throw new PetNeedsSomethingException("Oops! Your shoes is wet...");
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

    public boolean getisItSick() {
        return isItSick;
    }


}
