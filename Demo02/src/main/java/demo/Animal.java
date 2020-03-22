package demo;


import demo.exceptions.PetDiedException;
import demo.exceptions.PetGrewUpException;

import java.util.Collections;
import java.util.HashMap;

public abstract class Animal implements Actions {
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


    private void changeAge() throws PetGrewUpException {
        if (age < MAX_AGE) {
            age += 0.5;
        } else {
            throw new PetGrewUpException("It's time to say goodbye...");
        }
    }

    private int changeConditions(int changeableValue, int currentValue, int maxValue) throws PetDiedException {
        int newValue = currentValue + changeableValue;
        if (newValue > 0) {
            return Math.min(newValue, maxValue);
        } else {
            throw new PetDiedException("It's YOUR FAULT!");
        }
    }

    public String checkNextAction() {
        HashMap<String, Double> sp = new HashMap<>();
        sp.put("healthPoint", calculatePercent(healthPoint, MAX_HEALTH_POINT));
        sp.put("happiness", calculatePercent(happiness, MAX_HAPPINESS));
        sp.put("satiety", calculatePercent(satiety, MAX_SATIETY));
        sp.put("purity", calculatePercent(purity, MAX_PURITY));
        Double min = Collections.min(sp.values());
        String message = null;
        switch (getKeyFromValue(sp, min)) {
            case "healthPoint":
                message = "Something wrong, I'm feeling bad...";
                break;
            case "happiness":
                if (sp.get("happiness") < 50) {
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

    private static String getKeyFromValue(HashMap<String, Double> hm, Double value) {
        for (String keyName : hm.keySet()) {
            if (hm.get(keyName).equals(value)) {
                return keyName;
            }
        }
        return "";
    }

    private double calculatePercent(int presentValue, int maxValue) {
        return (double) presentValue / maxValue;
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
