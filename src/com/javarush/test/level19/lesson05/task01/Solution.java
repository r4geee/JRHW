package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        FileReader fileReader = new FileReader(path1);
        FileWriter fileWriter = new FileWriter(path2);
        int counter = 1;

        while (fileReader.ready())
        {
            int data = fileReader.read();
            if(counter % 2 == 0)
            {
                fileWriter.write(data);
            }
            counter++;
        }

        reader.close();
        fileReader.close();
        fileWriter.close();


    }
}
