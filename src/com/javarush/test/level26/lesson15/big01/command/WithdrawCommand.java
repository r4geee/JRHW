package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Test on 1/6/2015.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        boolean inputCorrect = false;
        boolean retry = false;
        while (!inputCorrect)
        {
            if (retry)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                retry = false;
            }
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String sumToWithDraw = ConsoleHelper.readString();
            Pattern pattern = Pattern.compile("[1-9]\\d*");
            Matcher matcher = pattern.matcher(sumToWithDraw);
            if (!matcher.matches())
            {
                retry = true;
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(Integer.parseInt(sumToWithDraw)))
            {
                continue;
            }
            Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            try
            {
                map.putAll(currencyManipulator.withdrawAmount(Integer.parseInt(sumToWithDraw)));
                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                {
                    System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sumToWithDraw, currency));
                inputCorrect = true;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
        }


    }
}
