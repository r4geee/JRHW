package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args)
    {
        //...
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            while (fileInputStream.available() > 0)
            {
                int data = fileInputStream.read();
                buf.write((byte) data);
            }
            String input = buf.toString().trim().replaceAll("[\\s]+", " ");
            StringBuilder result = new StringBuilder();
            if (input.length() != 0)
            {
                String[] words = input.split(" ");
                result = getLine(words);
            }
            System.out.println(result.toString().trim());
            reader.close();
            fileInputStream.close();
            buf.close();
        }
        catch (IOException e)
        {

        }

    }

    public static StringBuilder getLine(String... words) throws IOException
    {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0 || words[0].isEmpty()) return result;
        if (words.length == 1)
        {
            result.append(words[0].trim());
            return result;
        }
        List<String> list = new ArrayList<>();
        for (String word : words)
        {
            list.add(word);
        }
        Collections.sort(list);
        result = addNewWord(list, result);

        return result;
    }

    private static StringBuilder addNewWord(List<String> list, StringBuilder result)
    {
        for (int i = 0; i < list.size(); i++)
        {
            String currentString = list.get(i);
            if ((result.toString().equals("")) || (result.toString().toLowerCase().charAt(result.toString().length() - 2) == list.get(i).toLowerCase().charAt(0)))
            {
                result.append(currentString + " ");
                list.remove(i);
                result = addNewWord(list, result);
                if (list.size() != 0)
                {
                    list.add(i, currentString);
                    result.delete(result.length() - currentString.length() - 1, result.length());
                }
            }
        }
        return result;
    }
}
