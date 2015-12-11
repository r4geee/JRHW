package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Test on 4/24/2015.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg + " was cooked by " + o);
    }
}
