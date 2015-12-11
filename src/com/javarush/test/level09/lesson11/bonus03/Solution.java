package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                for (int y = i+1; y < array.length; y++ )
                {
                    if (isNumber(array[y]))
                    {
                        int tempI = Integer.parseInt(array[i]);
                        int tempY = Integer.parseInt(array[y]);
                        if (tempY > tempI)
                        {
                            int temp = tempI;
                            tempI = tempY;
                            tempY = temp;
                            array[i] = Integer.toString(tempI);
                            array[y] = Integer.toString(tempY);
                        }
                    }
                }
            }
            else
            {
                for (int y = i+1; y < array.length; y++ )
                {
                    if (!isNumber(array[y]))
                    {
                        if (isGreaterThen(array[i], array[y]))
                        {
                            String temp = array[i];
                            array[i] = array[y];
                            array[y] = temp;
                        }
                    }
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
