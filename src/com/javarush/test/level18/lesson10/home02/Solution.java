package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {

    public static int total = 0;
    public static int space = 0;
    public static double result = 0.0;

    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        total = inputStream.available();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            if ((char) data == ' ')
                space++;
        }

        result = (double) space/total*100;
        double roundedResult = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        System.out.println(roundedResult);
        inputStream.close();
    }
}
