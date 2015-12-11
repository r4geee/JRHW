package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    static int a[] = new int[5];

    public static void main(String[] args) throws Exception
    {

        boolean boolCheck = false;
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0;i<5;i++)
        {
            a[i] = Integer.parseInt(reader.readLine());
        }

        while (!boolCheck)
        {
            boolCheck = Check();
            if (!boolCheck)
            {
                Sort();
            }
        }

        for (int i = 0;i<5;i++)
        {
            System.out.println(a[i]);
        }
    }

    public static boolean Check()
    {
        boolean check = true;
        for (int i = 0;i<4;i++)
        {
            if (a[i] > a[i+1])
            {
                check = false;
            }
        }
        return check;
    }

    public static void Sort()
    {
        int intTemp;
        for (int i = 0;i<4;i++)
        {
            if (a[i] > a [i+1])
            {
                intTemp = a[i];
                a[i] = a[i+1];
                a[i+1] = intTemp;
            }
        }
    }

}
