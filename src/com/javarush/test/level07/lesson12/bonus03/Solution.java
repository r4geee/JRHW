package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        sort(numbers);

        for (int x : numbers)
        {
            System.out.println(x);
        }
    }

    public static void sort(ArrayList<Integer> numbers)
    {
        while (!Check(numbers))
        {
            for (int i = 0; i < numbers.size()-1; i++)
            {
                if (numbers.get(i) < numbers.get(i+1))
                {
                    int intTemp = numbers.get(i);
                    numbers.remove(i);
                    numbers.add(i+1, intTemp);
                }
            }
        }
    }

    public static boolean Check(ArrayList<Integer> numbers)
    {
        boolean result = true;
        for (int i = 0; i < numbers.size()-1; i++)
        {
            if (numbers.get(i) < numbers.get(i+1))
                result = false;
        }

        return result;
    }


}
