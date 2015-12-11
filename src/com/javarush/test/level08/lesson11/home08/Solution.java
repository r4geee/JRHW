package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        array = sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static int[] sort(int[] array)
    {
        while (!Check(array))
        {
            for (int i = 0; i < array.length-1;i++)
            {
                if (array[i] < array[i+1])
                {
                    int intTemp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = intTemp;
                }
            }
        }
        return array;
    }

    public static boolean Check (int[] array)
    {
        boolean sorted = true;
        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i] < array[i+1])
                sorted = false;
        }
        return sorted;
    }
}
