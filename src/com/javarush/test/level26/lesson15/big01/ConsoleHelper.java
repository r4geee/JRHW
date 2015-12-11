package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexei on 26.12.2014.
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common");
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String input = null;
        try
        {
            input = bufferedReader.readLine();
        }
        catch (IOException e)
        {

        }
        if (input.toUpperCase().equals("EXIT"))
        {
            throw new InterruptOperationException();
        }
        return input;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String currencyCode = "";
        writeMessage(res.getString("choose.currency.code"));
        currencyCode = readString();
        while (currencyCode.length() != 3)
        {
            writeMessage(res.getString("choose.currency.code"));
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] result = null;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        boolean inputCorrect = false;
        boolean retry = false;
        inputLoop:
        while (!inputCorrect)
        {
            if (retry)
            {
                writeMessage(res.getString("invalid.data"));
            }
            result = readString().split(" ");
            if (result.length != 2)
            {
                retry = true;
                continue ;
            }
            Pattern pattern = Pattern.compile("[1-9]\\d*");
            for (String s : result)
            {
                Matcher matcher = pattern.matcher(s);
                if (!matcher.matches())
                {
                    retry = true;
                    continue inputLoop;
                }
            }
            inputCorrect = true;
        }
        return result;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        //writeMessage(res.getString("choose.operation") + ": 1 - " + res.getString("operation.INFO")+ ", 2 - " + res.getString("operation.DEPOSIT")+ ", 3 - " + res.getString("operation.WITHDRAW")+ ", 4 - " + res.getString("operation.EXIT"));
        //writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("choose.operation"));
        writeMessage(String.format("%s - %d, %s - %d, %s - %d, %s - %d",
                res.getString("operation.INFO"), Operation.INFO.ordinal(),
                res.getString("operation.DEPOSIT"), Operation.DEPOSIT.ordinal(),
                res.getString("operation.WITHDRAW"), Operation.WITHDRAW.ordinal(),
                res.getString("operation.EXIT"), Operation.EXIT.ordinal()));
        try
        {
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        }
        catch (IllegalArgumentException e)
        {
            writeMessage(res.getString("invalid.data"));
            return askOperation();
        }
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }
}
