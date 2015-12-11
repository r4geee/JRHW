package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("January"))
        {
            System.out.println("Jan is 1 month");
        }
        else if (s.equals("February"))
        {
            System.out.println("Feb is 2 month");
        }
        else if (s.equals("March"))
        {
            System.out.println("March is 3 month");
        }
        else if (s.equals("April"))
        {
            System.out.println("Jan is 4 month");
        }
        else if (s.equals("May"))
        {
            System.out.println("May is 5 month");
        }
        else if (s.equals("June"))
        {
            System.out.println("June is 6 month");
        }
        else if (s.equals("July"))
        {
            System.out.println("July is 7 month");
        }
        else if (s.equals("August"))
        {
            System.out.println("August is 8 month");
        }
        else if (s.equals("September"))
        {
            System.out.println("September is 9 month");
        }
        else if (s.equals("October"))
        {
            System.out.println("October is 10 month");
        }
        else if (s.equals("November"))
        {
            System.out.println("November is 11 month");
        }
        else if (s.equals("December"))
        {
            System.out.println("December is 12 month");
        }
    }

}
