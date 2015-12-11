package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        String path3 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(path1);
        FileInputStream fileInputStream1 = new FileInputStream(path2);
        FileInputStream fileInputStream2 = new FileInputStream(path3);

        while (fileInputStream1.available() > 0)
        {
            int data = fileInputStream1.read();
            outputStream.write(data);
        }

        while (fileInputStream2.available() > 0)
        {
            int data = fileInputStream2.read();
            outputStream.write(data);
        }

        fileInputStream1.close();
        fileInputStream2.close();
        outputStream.close();
        reader.close();

    }
}
