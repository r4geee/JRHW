package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        while (fileReader.ready())
        {
            int data = fileReader.read();
            buf.write(data);
        }

        String s = buf.toString();
        String[] temp = s.split(" ");
        for (int i = 0; i<temp.length;i++)
        {
            if (isNumber(temp[i]))
            {
                String nnn = temp[i] + " ";
                fileWriter.write(nnn.toCharArray());
            }
        }

        reader.close();
        fileReader.close();
        fileWriter.close();
        buf.close();


    }

    public static boolean isNumber(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
