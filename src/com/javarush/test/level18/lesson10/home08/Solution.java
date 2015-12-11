package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        do
        {
            s = reader.readLine();
            Thread thread = new ReadThread(s);
            thread.start();
        }
        while (!s.equals("exit"));

        reader.close();

    }

    public static class ReadThread extends Thread {

        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                Map<Integer, Integer> byteList = new HashMap<Integer, Integer>();
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available()> 0)
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
                        resultMap.put(fileName, key);
                    }
                }
                fileInputStream.close();

            }
            catch (IOException e)
            {

            }
        }
    }
}
