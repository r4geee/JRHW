package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.*;

public class Solution {
    private static String action;
    private static int id;
    private static String productName;
    private static String price;
    private static String quantity;
    public static void main(String[] args) throws IOException
    {
        action = args[0];
        String newLine = "";
        if (action.equals("-u"))
        {
            id = Integer.parseInt(args[1]);
            productName = args[2];
            price = args[3];
            quantity = args[4];
        }
        else if (action.equals("-d"))
        {
            id = Integer.parseInt(args[1]);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(path));
        Map<Integer, String>  map = new HashMap<Integer, String>();
        List<Integer> idOrder = new ArrayList<Integer>();
        String s = "";
        while (reader1.ready())
        {
            s = reader1.readLine();      //читаем всю строку в файле

            String idChars = s.substring(0, 8);
            int id = Integer.parseInt(idChars.split(" ")[0]);
            map.put(id, s);
            idOrder.add(id);
        }

        reader1.close();
        reader.close();

        if (action.equals("-u"))
        {
            newLine = prepareOutput(id, productName, price, quantity);
            map.put(id, newLine);
        }
        else if (action.equals("-d"))
        {
            map.remove(id);
            Iterator<Integer> iterator = idOrder.iterator();
            while(iterator.hasNext())
            {
                Integer value = iterator.next();
                if (value.equals(id))
                {
                    iterator.remove();
                    break;
                }
            }
        }

        String output = "";

        for(Integer id : idOrder)
        {
            output = output + map.get(id) + System.lineSeparator();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(output.getBytes());
        fileOutputStream.close();

    }

    public static String prepareOutput(int id, String productName, String price, String quantity)
    {
        String out = "";
        String strId = Integer.toString(id);
        while(strId.length()<8)
        {
            strId = strId + " ";
        }

        while (productName.length()<30)
        {
            productName = productName + " ";
        }

        while (price.length()<8)
        {
            price = price + " ";
        }
        while (quantity.length()<4)
        {
            quantity = quantity + " ";
        }
        out = strId+productName+price+quantity;

        return out;
    }
}
