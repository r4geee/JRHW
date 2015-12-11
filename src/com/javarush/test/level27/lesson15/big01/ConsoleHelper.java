package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexei on 19.01.2015.
 */
public class ConsoleHelper
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String input = null;
        try
        {
            input = bufferedReader.readLine();
        }
        catch (IOException ignored)
        {

        }
        return input;
    }


    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> order = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        while (true)
        {
            String line = readString();
            line.trim();
            if ("exit".equalsIgnoreCase(line)) break;
            try
            {
                Dish dish = Dish.valueOf(line);
                order.add(dish);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(line + " is not detected");
            }
        }
        return order;
    }

}
