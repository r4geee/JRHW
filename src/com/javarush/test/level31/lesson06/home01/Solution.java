package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipArchivePath = args[1];
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipArchivePath));
        Map<String, byte[]> zipEntries = new HashMap<>();
        ZipEntry zipEntry;
        byte[] buff = new byte[1024];
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int l = 0;
            while ((l = zipInputStream.read(buff)) > 0) {
                byteArrayOutputStream.write(buff, 0, l);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            zipEntries.put(zipEntry.getName(), bytes);
        }
        zipInputStream.close();
        File toAdd = new File(fileName);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchivePath));
        for (Map.Entry<String, byte[]> pair : zipEntries.entrySet()) {
            if (pair.getKey().equals(toAdd.getName())) {
                continue;
            }
            zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
            zipOutputStream.write(pair.getValue());
            zipOutputStream.closeEntry();
        }
        zipOutputStream.putNextEntry(new ZipEntry("new/" + toAdd.getName()));
        Files.copy(toAdd.toPath(), zipOutputStream);
        zipOutputStream.close();
    }
}
