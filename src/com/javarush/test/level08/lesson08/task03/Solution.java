package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Пупкин", "Вася");
        map.put("Зайцев", "Петя");
        map.put("Ануфриев", "Илья");
        map.put("Лютер", "Юра");
        map.put("Куценко", "Гоша");
        map.put("Воронов", "Гоша");
        map.put("Зайцев2", "Вася");
        map.put("Цой", "Виктор");
        map.put("Бут", "Виктор");
        map.put("Путин", "Владимир");
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int counter = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            if (name.equals(value))
                counter++;
        }
        return counter;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {


        int counter = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (familiya.equals(key))
                counter++;
        }
        return counter;

    }
}
