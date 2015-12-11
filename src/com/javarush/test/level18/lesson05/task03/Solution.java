package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
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
        String path3 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream outputStream1 = new FileOutputStream(path2);
        FileOutputStream outputStream2 = new FileOutputStream(path3);
        int buffer1Length = 0;
        int buffer2Length = 0;

        if (fileInputStream.available() > 0) {

            if (fileInputStream.available() % 2 == 0)
            {
                buffer1Length = fileInputStream.available()/2;
                buffer2Length = fileInputStream.available()/2;
            }
            else
            {
                buffer1Length = fileInputStream.available()/2+1;
                buffer2Length = fileInputStream.available()/2;
            }
            byte[] buffer1 = new byte[buffer1Length];
            byte[] buffer2 = new byte[buffer2Length];

            fileInputStream.read(buffer1);
            outputStream1.write(buffer1);
            fileInputStream.read(buffer2);
            outputStream2.write(buffer2);
        }

        reader.close();
        fileInputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
