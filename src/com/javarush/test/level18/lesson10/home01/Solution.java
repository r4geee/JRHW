package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static char[] englishLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static int englishLettersNumber = 0;

    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            char temp = (char) data;

            for (char c : englishLetters)
            {
                if (temp == c )
                    englishLettersNumber++;
            }
        }

        System.out.println(englishLettersNumber);
        inputStream.close();
    }
}
