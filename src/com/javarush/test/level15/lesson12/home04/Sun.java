package com.javarush.test.level15.lesson12.home04;

/**
 * Created by arostovshchikov on 27/6/2014.
 */
public class Sun implements Planet
{
    private static Sun sun;

    public static Sun getInstance()
    {
        if (sun == null)
        {
            sun = new Sun();
        }
        return sun;
    }

    private Sun()
    {

    }
}
