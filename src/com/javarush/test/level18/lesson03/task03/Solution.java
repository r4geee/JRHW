package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);

        Map<Integer, Integer> byteList = new HashMap<Integer, Integer>();

        while (fileInputStream.available() >0)
        {
            int data = fileInputStream.read();
            if (!byteList.containsKey(data))
                byteList.put(data, 1);
            else
                byteList.put(data, byteList.get(data)+1);
        }

        int maxTimes = 0;
        for (Map.Entry<Integer, Integer> pair : byteList.entrySet())
        {
            Integer value = pair.getValue();
            if (value > maxTimes)
            {
                maxTimes = value;
            }
        }
        for (Map.Entry<Integer, Integer> pair : byteList.entrySet())
        {
            Integer key = pair.getKey();
            Integer value = pair.getValue();
            if (value == maxTimes)
            {
                System.out.print(key + " ");
            }
        }
        reader.close();
        fileInputStream.close();
    }
}
