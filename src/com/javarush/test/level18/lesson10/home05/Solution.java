package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        int data;
        byte b;
        while (fileInputStream.available()>0)
        {
            data = fileInputStream.read();
            b = (byte) data;
            buf.write(b);
        }

        String[] numberList = buf.toString().split(" ");

        List<Double> doubleList = new ArrayList<Double>();
        for (String s : numberList)
        {
            doubleList.add(Double.parseDouble(s));
        }

        List<Integer> roundedNumberList = new ArrayList<Integer>();
        for (Double d : doubleList)
        {
            //double roundedResult = new BigDecimal(d).setScale(0, RoundingMode.HALF_EVEN).doubleValue();
            double roundedResult = Math.round(d);
            int newValue = (int) roundedResult;
            roundedNumberList.add(newValue);
        }


        String result = "";
        for (Integer i : roundedNumberList)
            result += i.toString() + " ";

        fileOutputStream.write(result.getBytes());


    }
}
