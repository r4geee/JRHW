package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        while (reader.ready())
        {
            String s = reader.readLine();
            String[] words = s.split(" ");
            List<String> wordsForOutput = new ArrayList<String>();
            for (int i = 0; i < words.length; i++)
            {
                String word = words[i];
                if (word.length() > 6)
                    wordsForOutput.add(word);
            }
            String output = "";
            for (String wordOP : wordsForOutput)
            {
                output = output + wordOP + ",";
            }
            if (!output.equals(""))
                output = output.substring(0, output.length() - 1);
            if(reader.ready() && !output.equals(""))
                output = output + System.lineSeparator();
            fileWriter.write(output.toCharArray());
        }
        reader.close();
        fileWriter.close();

    }
}
