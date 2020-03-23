package demo;


import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;
import demo.util.UtilityMethods;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;


public abstract class Animal implements Actions {
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

    @Override
    public String toFeed() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(2, healthPoint, MAX_HEALTH_POINT);//add methods increase health
        happiness = changeConditions(1, happiness, MAX_HAPPINESS);
        satiety = changeConditions(10, satiety, MAX_SATIETY);
        purity = changeConditions(-2, happiness, MAX_HAPPINESS);
        changeAge();
        return checkNextAction();
    }

    @Override
    public String toPlay() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-2, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(4, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        purity = changeConditions(-2, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    @Override
    public String toScold() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-2, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(-2, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        changeAge();
        return checkNextAction();
    }

    @Override
    public String toStroke() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-2, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(2, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        changeAge();
        return checkNextAction();
    }

    @Override
    public String toWash() throws PetDiedException, PetGrewUpException {
        healthPoint = changeConditions(2, healthPoint, MAX_HEALTH_POINT);
        satiety = changeConditions(-1, satiety, MAX_SATIETY);
        purity = changeConditions(5, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }


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
     * Change current age on 0.5 points.
     *
     * @throws PetGrewUpException if the animal age >= MAX_AGE
     */
    @Override
    public String toSing() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(1, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(10, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-2, satiety, MAX_SATIETY);
        purity = changeConditions(-2, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    @Override
    public String toDance() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(1, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(15, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-5, satiety, MAX_SATIETY);
        purity = changeConditions(-5, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }

    @Override
    public String toWashDishes() throws PetGrewUpException, PetDiedException {
        healthPoint = changeConditions(-1, healthPoint, MAX_HEALTH_POINT);
        happiness = changeConditions(-5, happiness, MAX_HAPPINESS);
        satiety = changeConditions(-2, satiety, MAX_SATIETY);
        purity = changeConditions(-2, purity, MAX_PURITY);
        changeAge();
        return checkNextAction();
    }


    private void changeAge() throws PetGrewUpException {
        if (age < MAX_AGE) {
            age += 0.2;
        } else {
            throw new PetGrewUpException("It's time to say goodbye...");
        }
    }

    /**
     * Changes current points of animal.
     *
     * @param changeableValue on how much changes point.
     * @param currentValue which point changes.
     * @param maxValue constant of maximum animal point.
     * @return
     * @throws PetDiedException when point less then 0.
     */
    private int changeConditions(int changeableValue, int currentValue, int maxValue) throws PetDiedException {
        int newValue = currentValue + changeableValue;
        if (newValue > 0) {
            return Math.min(newValue, maxValue);
        } else {
            throw new PetDiedException("It's YOUR FAULT!");
        }
    }

    /**
     *
     * @return
     */
    public String checkNextAction() {
        HashMap<Double, String> sp = new HashMap<>();

        sp.put(UtilityMethods.calculatePercent(healthPoint, MAX_HEALTH_POINT), "healthPoint");
        sp.put(UtilityMethods.calculatePercent(happiness, MAX_HAPPINESS), "happiness");
        sp.put(UtilityMethods.calculatePercent(satiety, MAX_SATIETY), "satiety");
        sp.put(UtilityMethods.calculatePercent(purity, MAX_PURITY), "purity");
        Double min = Collections.min(sp.keySet());

        String message = null;
        switch (sp.get(min)) {
            case "healthPoint":
                message = "Something wrong, I'm feeling bad...";
                break;
            case "happiness":
                if (UtilityMethods.calculatePercent(happiness, MAX_HAPPINESS) < 50) {
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


    /**
     * Search point on hasMap.
     *
     * @param hm
     * @param value
     * @return
     */
    private static String getKeyFromValue(HashMap<String, Double> hm, Double value) {
        for (String keyName : hm.keySet()) {
            if (hm.get(keyName).equals(value)) {
                return keyName;
            }
        }
        return "";
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
}
