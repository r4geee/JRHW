package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        //String path = "C:\\asd.txt";
        InputStream inputStream = new FileInputStream(path);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> evenOnly = new ArrayList<Integer>();
        while (reader1.ready())
        {
            list.add(Integer.parseInt(reader1.readLine()));
        }

        for (int i = 0; i < list.size();i++)
        {
            if (list.get(i) % 2 == 0)
            {
                evenOnly.add(list.get(i));
            }
        }
        Collections.sort(evenOnly);

        for (Integer i : evenOnly)
            System.out.println(i);


        inputStream.close();
    }
}
