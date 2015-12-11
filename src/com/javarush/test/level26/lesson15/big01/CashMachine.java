package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Alexei on 26.12.2014.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
        try
        {
            Operation operation = Operation.LOGIN;
            CommandExecutor.execute(operation);
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e)
        {
            ConsoleHelper.printExitMessage();
        }

    }
}
