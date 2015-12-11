package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);

/*        if (fileInputStream.available() > 0)
        {
            int bufSize = fileInputStream.available();
            int[] buffer = new int[bufSize];
            while (fileInputStream.available() > 0)
            {
                for (int i = bufSize-1; i >= 0; i--)
                {
                    buffer[i] = fileInputStream.read();
                }
            }

            for (int i = 0; i < bufSize; i++)
            {
                fileOutputStream.write(buffer[i]);
            }


        }*/
        if (fileInputStream.available() > 0)
        {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            for (int i = buffer.length - 1; i >= 0; i--)
            {
                fileOutputStream.write(buffer[i]);
            }
        }

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
