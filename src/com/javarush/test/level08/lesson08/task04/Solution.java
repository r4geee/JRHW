package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Tom", new Date("JULY 22 1982"));
        map.put("Arbus", new Date("DEC 1 1977"));
        map.put("Baby", new Date("NOV 15 1984"));
        map.put("Cat", new Date("AUG 3 1982"));
        map.put("Dog", new Date("OCT 27 1983"));
        map.put("Eat", new Date("JAN 6 1979"));
        map.put("Food", new Date("FEB 17 1982"));
        map.put("Gevey", new Date("MAY 29 1980"));
        map.put("Hugs", new Date("JULY 4 1981"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String , Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            if ((value.getMonth() > 4) && (value.getMonth() < 8))
                //map.remove(pair);
            iterator.remove();

        }
    }

    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String key = pair.getKey();
            Date value = pair.getValue();
            System.out.println(key + " " + value);
        }
    }
}
