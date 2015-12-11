package MyTests;


import com.javarush.test.level20.lesson02.task05.Solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;

/**
 * Created by Alexei on 26.12.2014.
 */
public class MapTest
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(3, 333);
        map1.put(22, 222);
        map1.put(1, 111);
        map1.put(54, 1444);
/*        for (Map.Entry<Integer, Integer> entry : map1.entrySet())
        {
            System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
        }*/
        Map<Integer, Integer> map2 = new TreeMap<>(Collections.reverseOrder());
        map2.putAll(map1);
        Map<Integer,Integer> map3 = new TreeMap<>();
        map3.putAll(map2);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("=====");
        for (Map.Entry<Integer, Integer> entry : map2.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("=====");
        for (Map.Entry<Integer, Integer> entry : map3.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
