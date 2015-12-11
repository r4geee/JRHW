package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        String s = new String();
        List<String> list = new ArrayList<String>();
        OutputStream outputStream = new FileOutputStream(path);
        while (!s.equals("exit"))
        {
            s = reader.readLine();
            list.add(s);

        }

        for (String str : list)
        {
            PrintStream out = new PrintStream(outputStream);
            out.println(str);
        }

        outputStream.close();

    }
}
