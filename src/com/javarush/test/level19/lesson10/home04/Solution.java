package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerf = new BufferedReader(new FileReader(reader.readLine()));
        List <String> inputList = new ArrayList<String>();
        List <String> results = new ArrayList<String>();
        while (readerf.ready())
        {
            inputList.add(readerf.readLine());
        }

        for (String input : inputList)
        {
            int matchcounter = 0;
            for (String word : words)
            {
                if(input.contains(word))
                    matchcounter++;
            }

            if(matchcounter == 2)
                results.add(input);
        }

        for (String result : results)
            System.out.println(result);

        reader.close();
        readerf.close();

    }
}
