package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        List<String> list = new ArrayList<String>();
        Object objValue = null;
        int qIndex =0;
        for (int i = 0; i < s.length();i++)
        {
            if (s.charAt(i) == '?')
            {
                qIndex = i;
                break;
            }
        }
        String afterQ = s.substring(qIndex+1);
        String[] paramsAndValues = afterQ.split("&");
        for (String str : paramsAndValues)
        {
            String[] temp = str.split("=");
            list.add(temp[0]);
            if (temp[0].equals("obj") )
            {
                objValue = temp[1];
            }
        }
        for (String str : list)
        {
            System.out.print(str + " ");
        }
        if (objValue != null)
        {
            System.out.println();
            try
            {
                alert(Double.parseDouble(objValue.toString()));
            }
            catch (Exception e)
            {
                alert(objValue.toString());
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
