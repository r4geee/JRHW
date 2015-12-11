package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        BufferedReader readerf = new BufferedReader(new FileReader(path));

        while (readerf.ready())
        {
            String str = readerf.readLine();
            StringBuilder stringBuilder = new StringBuilder(str).reverse();
            String out = stringBuilder.toString();
            System.out.println(out);
        }
        reader.close();
        readerf.close();
    }
}
