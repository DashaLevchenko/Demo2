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
    public void toFeed() throws PetGrewUpException, PetDiedException {
        healthPoint += 2;
        happiness += 1;
        satiety += 10;
        age += 0.2;
        purity -= 2;
        check_stage(); //have to be static...

    }

    @Override
    public void toPlay() {

    }

    @Override
    public void toScold() throws PetGrewUpException, PetDiedException {
        healthPoint -= 2;
        happiness -= 2;
        satiety -= 1;
        age += 0.2;
        check_stage();
    }

    @Override
    public void toStroke() throws PetGrewUpException, PetDiedException {
        healthPoint -= 2;
        happiness += 2;
        satiety -= 1;
        age += 0.2;
        check_stage();
    }

    @Override
    public void toWash() throws PetGrewUpException, PetDiedException {
        healthPoint += 2;
        satiety -= 1;
        age += 0.2;
        purity += 3;
        check_stage();
    }
    
    @Override
    public void toHeal() {

    }

    public void check_stage() throws PetDiedException, PetGrewUpException {
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
