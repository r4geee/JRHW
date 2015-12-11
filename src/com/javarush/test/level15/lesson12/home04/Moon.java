package com.javarush.test.level15.lesson12.home04;

/**
 * Created by arostovshchikov on 27/6/2014.
 */
public class Moon implements Planet
{
    private static Moon moon;

    public static Moon getInstance()
    {
        if (moon == null)
        {
            moon = new Moon();
        }
        return moon;
    }

    private Moon()
    {

    }
}
