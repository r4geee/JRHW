package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*        int N;
        int maximum = 0;
        int input;
        N = Integer.parseInt(reader.readLine());
        if (N > 0)
        {
            maximum = Integer.parseInt(reader.readLine());
            for (int i = 1; i < N; i++)
            {
                input = Integer.parseInt(reader.readLine());
                if (input > maximum)
                    maximum = input;
            }
        }*/
        int N = Integer.parseInt(reader.readLine());
        int maximum = Integer.MIN_VALUE;
        if (N > 0)
        {
            for (int i = 0; i < N; i++)
            {
                int input = Integer.parseInt(reader.readLine());
                if (input > maximum)
                    maximum = input;
            }
            System.out.println(maximum);
        }
    }
}
