package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
*/

import java.io.*;

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
            buf.write((char) data);
        }

        String s = buf.toString();
        s = s.replaceAll("\\p{Punct}", "");
        fileWriter.write(s.toCharArray());

        buf.close();
        reader.close();
        fileReader.close();
        fileWriter.close();
    }

}
