package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Alexei on 28.11.2015.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
