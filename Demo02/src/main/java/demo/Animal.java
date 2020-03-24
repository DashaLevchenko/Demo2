package demo;


import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;
import demo.util.UtilityMethod;

import java.util.Collections;
import java.util.HashMap;


public abstract class Animal implements Livable {
    /**
     * Constants of maximum animal points.
     */
    public static final int MAX_AGE = 5;
    public static final int MAX_HEALTH_POINT = 50;
    public static final int MAX_HAPPINESS = 10;
    public static final int MAX_SATIETY = 50;
    public static final int MAX_PURITY = 10;

    private String name;
    private int healthPoint;
    private int happiness;
    private int satiety;
    private double age;
    private int purity;

    /**
     * Start points of game.
     *
     * @param name input animal name
     */
    public Animal(String name) {
        healthPoint = 25;
        happiness = 5;
        satiety = 25;
        age = 0;
        purity = 0;
        this.name = name;
    }

    /**
     * Changes points of animal when pet asked to feed it.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    @Override
    public String toFeed() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(2, healthPoint, MAX_HEALTH_POINT);//add methods increase health
        happiness = changeConditions(1, happiness, MAX_HAPPINESS);
        satiety = changeConditions(10, satiety, MAX_SATIETY);
        purity = changeConditions(-2, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    /**
     * Changes points of animal when pet asked to play with it.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    @Override
    public String toPlay() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-2, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(4, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        purity = changeConditions(-2, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    /**
     * Changes points of animal when pet do smth wrong.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    @Override
    public String toScold() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-2, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(-2, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        changeAge();
        return checkNextAction();
    }

    /**
     * Changes points of animal when pet asked to stroke its tummy.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    @Override
    public String toStroke() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-2, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(2, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        changeAge();
        return checkNextAction();
    }

    /**
     * Changes points of animal when pet was dirty .
     *
     * @return
     * @throws PetDiedException
     * @throws PetGrewUpException
     */
    @Override
    public String toWash() throws PetDiedException, PetGrewUpException {
        healthPoint = changeConditions(2, healthPoint, MAX_HEALTH_POINT);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        purity = changeConditions(5, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    /**
     * Changes points of animal when pet was ill.
     *
     * @return
     * @throws PetGrewUpException
     * @throws PetDiedException
     */
    @Override
    public String toHeal() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(18, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(-2, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-2, satiety, MAX_SATIETY);
        purity = changeConditions(-2, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    /**
     * Predicts next action with calculate percentages.
     *
     * @return
     */
    public String checkNextAction() throws PetDiedException {
        if (healthPoint <= 0) {
            throw new PetDiedException("Your pet is dead. Game over.");
        }
        HashMap<Double, String> sp = new HashMap<>();

        sp.put(UtilityMethod.calculatePercent(healthPoint, MAX_HEALTH_POINT), "healthPoint");
        sp.put(UtilityMethod.calculatePercent(happiness, MAX_HAPPINESS), "happiness");
        sp.put(UtilityMethod.calculatePercent(satiety, MAX_SATIETY), "satiety");
        sp.put(UtilityMethod.calculatePercent(purity, MAX_PURITY), "purity");
        Double min = Collections.min(sp.keySet());

        String message = null;
        switch (sp.get(min)) {
            case "healthPoint":
                message = "Something wrong, I'm feeling bad...";
                break;
            case "happiness":
                if (UtilityMethod.calculatePercent(happiness, MAX_HAPPINESS) < 50) {
                    message = "Play with me!";
                } else {
                    message = "Purrr! Scratch my tummy!";
                }
                break;
            case "satiety":
                message = "I'm hungry!";
                break;
            case "purity":
                message = "I'm dirty. You know what to do!";
                break;
            default:
                message = "Shit happens";
                break;
        }
        return message;
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

    public String getName() {
        return name;
    }

    /**
     * Changes current age on 0.5 points.
     *
     * @throws PetGrewUpException if the animal age >= MAX_AGE
     */
    private void changeAge() throws PetGrewUpException {
        if (age < MAX_AGE) {
            age += 0.5;
        } else {
            throw new PetGrewUpException("Congratulations! Your pet has been grew up! Game over.");
        }
    }

    /**
     * Changes current points of animal, if point less 0 throws exception.
     *
     * @param changeableValue on how much changes point.
     * @param currentValue    which point changes.
     * @param maxValue        constant of maximum animal point.
     * @return
     * @throws PetDiedException when point 0 or less then 0.
     */
    private int changeConditions(int changeableValue, int currentValue, int maxValue) {
        int newValue = currentValue + changeableValue;
        if (newValue > 0) {
            return Math.min(newValue, maxValue);
        } else {
            return 0;
        }
    }
}


