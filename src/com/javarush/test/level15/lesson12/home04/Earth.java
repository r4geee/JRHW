package com.javarush.test.level15.lesson12.home04;

/**
 * Created by arostovshchikov on 27/6/2014.
 */
public class Earth implements Planet
{
    private static Earth earth;

    public static Earth getInstance()
    {
        if (earth == null)
        {
            earth = new Earth();
        }
        return earth;
    }

    private Earth()
    {

    }
}
