package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Test on 1/6/2015.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency =  ConsoleHelper.askCurrencyCode();
        String[] denominationsAndCount = ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        currencyManipulator.addAmount(Integer.parseInt(denominationsAndCount[0]), Integer.parseInt(denominationsAndCount[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), (Integer.parseInt(denominationsAndCount[0]) * Integer.parseInt(denominationsAndCount[1])), currency) );
    }
}
