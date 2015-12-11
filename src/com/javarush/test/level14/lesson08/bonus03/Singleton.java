package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by arostovshchikov on 25/6/2014.
 */
public class Singleton
{
    private static Singleton singleton;
    public static Singleton getInstance()
    {
        return singleton;
    }
    private Singleton()
    {

    }
}
