package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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

public class Solution
{
    private static String action;
    private static String productName;
    private static String price;
    private static String quantity;
    public static void main(String[] args) throws Exception
    {
        action = args[0];
        productName = args[1];
        price = args[2];
        quantity = args[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(path));
        List<Integer> idList = new ArrayList<Integer>();
        List<String> lines = new ArrayList<String>();
        String s = "";

        if (action.equals("-c"))
        {
            while (reader1.ready())
            {
                s = reader1.readLine();      //читаем всю строку в файле
                lines.add(s);
                String idChars = s.substring(0, 8);
                int id = Integer.parseInt(idChars.split(" ")[0]);
                idList.add(id);
            }

            Collections.sort(idList);
            int newId=idList.get(idList.size()-1) + 1;

            String newLine = prepareOutput(newId, productName, price, quantity );



            FileOutputStream fileOutputStream = new FileOutputStream(path);
            String oldLines = "";
            for (String str : lines)
            {
                oldLines = oldLines + str + System.lineSeparator();
            }
            fileOutputStream.write((oldLines + newLine).getBytes());
            fileOutputStream.close();
        }

        reader.close();
        reader1.close();

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

