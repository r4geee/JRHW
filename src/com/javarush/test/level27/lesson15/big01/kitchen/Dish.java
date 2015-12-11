package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

/**
 * Created by Alexei on 19.01.2015.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        String resultString = Arrays.toString(Dish.values());
        if (Dish.values().length == 0) {
            return "";
        }
        return resultString.substring(resultString.indexOf("[") + 1, resultString.lastIndexOf("]"));
    }

    public int getDuration() {
        return duration;
    }
}
