package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    protected double amount;


    public double getAmount()
    {
        return amount;
    }

    public abstract String getCurrencyName();
}

