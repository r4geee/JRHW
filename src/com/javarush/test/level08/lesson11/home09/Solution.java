package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static boolean isDateOdd(String date)
    {
        boolean result = false;
        Date dDate = new Date(date);
        int days = dDate.getMonth() * 30 + dDate.getDay();
        if (days % 2 == 0 )
            result = true;
        return result;
    }
}
