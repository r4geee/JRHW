package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        while (fileReader.ready())
        {
            int data = fileReader.read();
            buf.write(data);
        }

        String s = buf.toString().toLowerCase();
        int result = 0;
        for (int i = 0; i<s.length()-4;i++)
        {
            String subs = s.substring(i, i+5);
            if (subs.equals("world"))
                result++;

        }
        System.out.println(result);

        reader.close();
        fileReader.close();
        buf.close();
    }
}
