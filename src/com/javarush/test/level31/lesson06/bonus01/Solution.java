package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) {
        try {
            String resultFileName = args[0];
            Map<String, byte[]> pieces = new TreeMap<>();
            for (int i = 1; i < args.length; i++) {
                FileInputStream fileInputStream = new FileInputStream(args[i]);
                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                String index = args[i].split("\\.")[args[i].split("\\.").length - 1];
                pieces.put(index, bytes);
                fileInputStream.close();
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            for (Map.Entry<String, byte[]> pair : pieces.entrySet()) {
                baos.write(pair.getValue());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
            byte[] buff = new byte[1024];
            while (zipInputStream.getNextEntry() != null) {
                int l = 0;
                while ((l = zipInputStream.read(buff)) > 0) {
                    fileOutputStream.write(buff, 0, l);
                }
            }
            zipInputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e) {

        }

    }
}
