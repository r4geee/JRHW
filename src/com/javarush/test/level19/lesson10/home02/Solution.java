package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader readerF = new BufferedReader(fileReader);

        Map<String, Double> map = new TreeMap<String, Double>();
        while (readerF.ready())
        {
            String[] s = readerF.readLine().split(" ");
            String name = s[0];
            Double money = Double.parseDouble(s[1]);

            if (!map.containsKey(name))
                map.put(name, money);
            else
                map.put(name, map.get(name) + money);
        }

        Double max = 0.0;


        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (max < pair.getValue())
                max = pair.getValue();
        }

        String output = "";
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue().equals(max))
            {
                output = output + pair.getKey() + " ";
            }
        }
        while (output.charAt(output.length()-1) == ' ')
        {
            output = output.substring(0, output.length()-1);
        }

        System.out.println(output);

        fileReader.close();
        readerF.close();

    }
}
