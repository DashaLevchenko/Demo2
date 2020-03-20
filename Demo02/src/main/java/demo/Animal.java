package demo;


import demo.exceptions.*;

import java.util.*;

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
    public String toFeed() throws PetGrewUpException, PetDiedException {
        changeHealthPoint(2);//add methods increase health
        changeHappiness(1);
        changeSatiety(10);
        changePurity(2);
        return checkNextAction();
    }

    @Override
    public String toPlay() throws PetGrewUpException, PetDiedException {
        changeHealthPoint(2);
        changeHappiness(4);
        changeSatiety(1);
        changePurity(2);
        return checkNextAction();
    }

    @Override
    public String toScold() throws PetGrewUpException, PetDiedException {
        changeHealthPoint(2);
        changeHappiness(2);
        changeSatiety(1);
        return checkNextAction();
    }

    @Override
    public String toStroke() throws PetGrewUpException, PetDiedException {
        changeHealthPoint(2);
        changeHappiness(2);
        changeSatiety(1);
        return checkNextAction();
    }

    @Override
    public String toWash() throws PetDiedException, PetGrewUpException {
        changeHealthPoint(2);
        changeSatiety(1);
        changePurity(5);
        return checkNextAction();
    }


    @Override
    public String toHeal() throws PetGrewUpException, PetDiedException {
        changeHealthPoint(18);
        changeHappiness(2);
        changeSatiety(2);
        changePurity(2);
        return checkNextAction();
    }


    /**
     * This method changes field {@code healthPoint}.
     * If add true, digit will added to {@code healthPoint},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     */
    private void changeHealthPoint(int digit) {
        changeAge();
        healthPoint = Math.min(healthPoint + digit, MAX_HEALTH_POINT);
    }

    /**
     * This method changes field {@code happiness}.
     * If add true, digit will added to {@code happiness},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changeHappiness(int digit) {
        happiness = Math.min(happiness + digit, MAX_HAPPINESS);
    }

    /**
     * This method changes field {@code satiety}.
     * If add true, digit will added to {@code satiety},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     */
    private void changeSatiety(int digit) {
        satiety = Math.min(satiety + digit, MAX_SATIETY);
    }

    /**
     * This method changes field {@code purity}.
     * If add true, digit will added to {@code purity},
     * else digit will subscribe
     *
     * @param digit Digit which need to add or subscribe
     * @param add   True if need to add, False if need to subscribe
     */
    private void changePurity(int digit) {
        purity = Math.min(purity + digit, MAX_PURITY);
    }

    private void changeAge() {
        if (age < MAX_AGE) {
            age += 0.5;
        }
    }

    private String checkNextAction(){
        HashMap<String, Double> sp = new HashMap<>();
        sp.put("healthPoint", calculatePercent(healthPoint, MAX_HEALTH_POINT));
        sp.put("happiness", calculatePercent(happiness, MAX_HAPPINESS));
        sp.put("satiety", calculatePercent(satiety, MAX_SATIETY));
        sp.put("purity", calculatePercent(purity, MAX_PURITY));
        Double min = Collections.min(sp.values());
        String message = null;
        switch (getKeyFromValue(sp, min)){
            case "healthPoint" :
                message = "Something wrong, I'm feeling bad...";
                break;
            case "happiness" :
                if(sp.get("happiness") < 50) {
                    message = "Play with me!";
                }
                else{
                    message = "Purrr! Scratch my tummy!";
                }
                break;
            case "satiety" :
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
        for (String keyName: hm.keySet()) {
            if (hm.get(keyName).equals(value)) {
                return keyName;
            }
        }
        return "";
    }

    private double calculatePercent(int presentValue, int maxValue){
        return (double)presentValue/maxValue;
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
