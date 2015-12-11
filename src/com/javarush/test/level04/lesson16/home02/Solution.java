package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)   throws Exception
/*    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        if (a > b && a < c)
            OP(a);
        else if (a > c && a < b)
            OP(a);
        else if (b > a && b < c)
            OP(b);
        else if (b > c && b < a)
            OP(b);
        else if (c > a && c < b)
            OP(c);
        else if (c > b && c < a)
            OP(c);
    }

    public static void OP(int x)
    {
        System.out.println(x);
    }*/
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        for(int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(array);
        System.out.println(array[1]);
    }
}
