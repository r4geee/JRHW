package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);
        char temp = ',';
        int compTo = (int) temp;
        int counter = 0;
        while (fileInputStream.available() >0)
        {
            int data = fileInputStream.read();
            if (data == compTo)
                counter++;
        }

        System.out.println(counter);

        reader.close();
        fileInputStream.close();
    }
}
