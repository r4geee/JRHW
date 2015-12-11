package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String action = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        int cypher = 100;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            if (action.equals("-e"))
                fileOutputStream.write(data + cypher);
            else if (action.equals("-d"))
                fileOutputStream.write(data-cypher);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }

}
