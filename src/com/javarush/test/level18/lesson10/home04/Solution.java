package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(path1);
        FileInputStream fileInputStream2 = new FileInputStream(path2);

        byte[] buffer1 = new byte[fileInputStream1.available()];
        byte[] buffer2 = new byte[fileInputStream2.available()];
        if (fileInputStream1.available() > 0)
        {
            fileInputStream1.read(buffer1);
        }
        if (fileInputStream2.available() > 0)
        {
            fileInputStream2.read(buffer2);
        }
        fileInputStream1.close();
        fileInputStream2.close();

        FileOutputStream fileOutputStream = new FileOutputStream(path1);
        fileOutputStream.write(buffer1);
        fileOutputStream.write(buffer2);
        reader.close();
        fileOutputStream.close();
    }
}
