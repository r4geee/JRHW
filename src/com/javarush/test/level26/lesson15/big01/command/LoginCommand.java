package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Test on 1/14/2015.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");

    @Override
    public void execute() throws InterruptOperationException
    {
        boolean inputCorrect = false;
        while (!inputCorrect)
        {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String inputLogin = ConsoleHelper.readString();
            Pattern pattern = Pattern.compile("\\d{12}");
            Matcher matcher = pattern.matcher(inputLogin);
            if (!matcher.matches())
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            String inputPIN  = ConsoleHelper.readString();
            pattern = Pattern.compile("\\d{4}");
            matcher = pattern.matcher(inputPIN);
            if (!matcher.matches())
            {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            if (validCreditCards.containsKey(inputLogin) && inputPIN.equals(validCreditCards.getString(inputLogin)))
            {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), inputLogin));
                inputCorrect = true;
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inputLogin));
            }
        }
    }
}
