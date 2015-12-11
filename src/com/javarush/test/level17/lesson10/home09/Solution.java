package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. выбросить исключение CorruptedDataException
4.2. очистить allLines от данных
Сигнатуру метода main не менять
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String path1 = reader.readLine();
            String path2 = reader.readLine();

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path1)));

            while (reader1.ready())
            {
                allLines.add(reader1.readLine());
            }

            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(path2)));
            while (reader2.ready())
            {
                forRemoveLines.add(reader2.readLine());
            }

            new Solution().joinData();


        }
        catch (IOException e)
        {

        }



    }

    public void joinData () throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
