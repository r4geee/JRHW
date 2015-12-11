package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        //String path = "D:\\test.txt";


        InputStream inputStream = new FileInputStream(path) ;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int data;
        byte b;
        while (inputStream.available()>0)
        {
            data = inputStream.read();
            b = (byte) data;
            buf.write(b);
        }
        System.out.println(buf.toString());
        inputStream.close();

    }
}
