package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String path = reader.readLine();
            try
            {

                FileInputStream fileInputStream = new FileInputStream(path);
                fileInputStream.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println(path);
                break;
            }


        }
        reader.close();
    }
}
