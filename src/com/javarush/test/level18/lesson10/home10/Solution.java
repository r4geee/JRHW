package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, byte[]> map = new TreeMap<>();
        String endFileName = "";



        while (true)
        {
            String s = reader.readLine();
            if (s.equals("end"))
                break;
            FileInputStream fileInputStream = new FileInputStream(s);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            String[] temp = s.split(".part");
            int partNumber = Integer.parseInt(temp[temp.length - 1]);

            if(endFileName.equals(""))
            {
                endFileName = temp[temp.length-2];
            }

            map.put(partNumber, buffer);

            fileInputStream.close();
        }


        FileOutputStream fileOutputStream = new FileOutputStream(endFileName);

        for (Map.Entry<Integer, byte[]> pair : map.entrySet())
        {
            byte[] buffer = pair.getValue();
            fileOutputStream.write(buffer);
        }

        fileOutputStream.close();
        reader.close();

    }
}
