package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            buf.write((byte) data);
        }
        String[] words = buf.toString().replaceAll(System.lineSeparator(), " ").split(" ");
        outerloop:
        for (int i = 0; i < words.length; i++)
        {
            if (words[i] == null || words[i].isEmpty())
                continue;
            String wordFirst = words[i];
            String wordFirstReversed = new StringBuilder(words[i]).reverse().toString();
            for (int y = i + 1; y < words.length; y++)
            {
                String wordSecond = words[y];

                if (wordFirstReversed.equals(wordSecond))
                {
                    Pair newPair = new Pair();
                    newPair.first = wordFirst;
                    newPair.second = wordSecond;
                    for (Pair pair : result)
                        if (pair.first.equals(wordFirst) || pair.first.equals(wordSecond))
                        {
                            words[i] = null;
                            words[y] = null;
                            break outerloop;
                        }
                    result.add(newPair);
                    words[i] = null;
                    words[y] = null;
                    break;
                }
            }
        }
        for (Pair pair : result)
            System.out.println(pair.toString());
        reader.close();
        fileInputStream.close();
        buf.close();


    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
