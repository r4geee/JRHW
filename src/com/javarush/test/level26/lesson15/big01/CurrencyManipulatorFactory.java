package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexei on 26.12.2014.
 */
public class CurrencyManipulatorFactory
{
    private static Set<CurrencyManipulator> currencyManipulators = new HashSet<>();
    private CurrencyManipulatorFactory()
    {

    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        for (CurrencyManipulator currencyManipulator : currencyManipulators)
        {
            if (currencyManipulator.getCurrencyCode().equals(currencyCode))
            {
                return currencyManipulator;
            }
        }
        CurrencyManipulator newCurrencyManipulator = new CurrencyManipulator(currencyCode);
        currencyManipulators.add(newCurrencyManipulator);
        return newCurrencyManipulator;
    }

    public static Collection getAllCurrencyManipulators()
    {
        return currencyManipulators;
    }
}
