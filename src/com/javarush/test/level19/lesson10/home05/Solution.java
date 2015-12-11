package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        while (fileInputStream.available()>0)
        {
            int data = fileInputStream.read();
            buf.write(data);
        }
        String s = buf.toString().replaceAll(System.lineSeparator(), " ");
        String[] words = s.split(" ");
        List<String> results = new ArrayList<String>();
        for (String word : words)
        {
            for (char c : word.toCharArray())
            {
                if (Character.isDigit(c))
                {
                    results.add(word);
                    break;
                }
            }
        }
        String output = "";
        for (String result : results)
        {
            output = output + result + " ";

        }
        while (output.charAt(output.length()-1) == ' ')
        {
            output = output.substring(0, output.length()-1);
        }

        fileOutputStream.write(output.getBytes());

        fileInputStream.close();
        fileOutputStream.close();
    }
}
