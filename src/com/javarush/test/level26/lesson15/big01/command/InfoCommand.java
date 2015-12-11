package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashSet;
import java.util.ResourceBundle;

/**
 * Created by Test on 1/6/2015.
 */
class InfoCommand implements Command
{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator currencyManipulator : (HashSet<CurrencyManipulator>) CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            hasMoney = currencyManipulator.hasMoney();
            if (hasMoney)
            {
                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            }
        }
        if (!hasMoney)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
