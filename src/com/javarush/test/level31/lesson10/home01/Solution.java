package com.javarush.test.level31.lesson10.home01;

import java.io.*;
import java.util.Properties;

/* Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.
Подсказка: возможно, Вам понадобится File.separator.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        //Properties properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/properties.xml");
        Properties properties = solution.getProperties("c:/properties.xml");
        properties.list(System.out);

        //properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/properties.txt");
        properties = solution.getProperties("c:/properties.txt");
        properties.list(System.out);

        //properties = solution.getProperties("src/com/javarush/test/level31/lesson10/task01/notExists");
        properties = solution.getProperties("c:/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName)
    {
        Properties properties = new Properties();
        if (fileName == null)
        {
            return properties;
        }
        try
        {
            if (fileName.endsWith(".xml"))
            {
                properties.loadFromXML(new FileInputStream(fileName));
            }
            else
            {
                properties.load(new FileInputStream(fileName));
            }
        }
        catch (IOException e)
        {
            return new Properties();
        }
        return properties;
    }

}

