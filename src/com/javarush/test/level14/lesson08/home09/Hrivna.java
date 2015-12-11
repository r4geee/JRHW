package com.javarush.test.level14.lesson08.home09;

/**
 * Created by arostovshchikov on 25/6/2014.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        this.amount = amount;
    }

    public String getCurrencyName()
    {
        return "HRN";
    }
}
